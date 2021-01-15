package shop.steamowls.steam.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;

public class ForgotPw implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//로그인여부 및 잘못된 접근
		//세션에 sq 가지고 있기
		HttpSession session = request.getSession();
		
		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);
		
		if(sq != null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/member/forgotPw.jsp");
		return forward;
	}
}
