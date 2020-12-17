package shop.steamowls.steam.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;

public class ProductAddProc implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		/*
		 * HttpSession session = request.getSession(); session.setAttribute("a",
		 * content);
		 */
		String content = request.getParameter("content");
		PrintWriter out = response.getWriter();
		out.println(content);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/admin/productAdd.jsp");
		return forward;
	}
}
