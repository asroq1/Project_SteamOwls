package shop.steamowls.steam.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;

public class Pdelete implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("/views/admin/productDelete.jsp");
		return forward;
	}
}
