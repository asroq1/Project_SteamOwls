package shop.steamowls.steam.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;

public class MemberManageProc implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setPath("/");
		forward.setRedirect(true);
		return forward;
	}
}
