package shop.steamowls.steam.mypage.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.BCrypt;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.MypageVo;

public class Mmodify implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 로그인여부 및 잘못된 접근
		// 세션에 sq 가지고 있기
		HttpSession session = request.getSession();

		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}

		// jsp에서 데이터 받기
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");

		if (name == null || tel == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('정보를 입력해주세요.'); location.href='/mypage/Mmodify';</script>");
			out.close();
			return null;
		}

		MypageVo mypageVo = new MypageVo();
		if (pw == null) {
			mypageVo.setSq(Integer.parseInt(sq));
			mypageVo.setName(name);
			mypageVo.setTel(tel);
		} else {
			mypageVo.setSq(Integer.parseInt(sq));
			mypageVo.setName(name);
			mypageVo.setPw(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
			mypageVo.setTel(tel);
		}

		MypageService svc = new MypageService();

		if (!svc.modify(mypageVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('회원정보수정에 실패하였습니다.'); history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/Mdetail.jsp");
		return forward;
	}
}
