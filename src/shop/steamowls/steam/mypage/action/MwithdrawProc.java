package shop.steamowls.steam.mypage.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.MypageVo;

public class MwithdrawProc implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}

		String pw = request.getParameter("pw");

		MypageVo mypageVo = new MypageVo();
		mypageVo.setSq(Integer.parseInt(sq));

		MypageService svc = new MypageService();
		if (!svc.withdraw(mypageVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다.'); history.back();</script>");
			out.close();
			return null;
		} else {
			lm.removeSession(sq);
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/");
		forward.setRedirect(true);
		return forward;
	}
}
