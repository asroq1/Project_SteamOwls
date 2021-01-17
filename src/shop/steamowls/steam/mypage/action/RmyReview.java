package shop.steamowls.steam.mypage.action;


import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.MypageVo;

public class RmyReview implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String member_sq = lm.getMemberSq(session);

		if (member_sq == null || member_sq.equals("")) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		MypageService svc = new MypageService();

		MypageVo mypageVo = new MypageVo();
		mypageVo.setSq(Integer.parseInt(member_sq));
		
		ArrayList<MypageVo> list = new ArrayList<MypageVo>();
		list = svc.rMyReview(mypageVo);
		if(list == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다.'); history.back();</script>");
			out.close();
			return null;
		}
	
		request.setAttribute("list", list);

		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/RmyReview.jsp");
		return forward;
	}
}
