package shop.steamowls.steam.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;

public class Logout implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(); // 인덱스에 잇는 세션을 겟세션으로 들고와야된다 (인덱스의 세션과 동일하다)
		LoginManager lm = LoginManager.getInstance();
		// 로그인을 sq로 하기 떄문에 sq떙겨와서 로그인 여부 확인
		String sq = lm.getMemberSq(session);
		if (sq != null) {
			lm.removeSession(sq);
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/");
		forward.setRedirect(true);
		return forward;
	}
}
