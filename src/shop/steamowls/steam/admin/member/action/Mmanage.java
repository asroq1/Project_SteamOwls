package shop.steamowls.steam.admin.member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.common.Pagenation;
import shop.steamowls.steam.admin.member.service.MemberService;
import shop.steamowls.steam.admin.member.vo.MemberVo;
import shop.steamowls.steam.admin.review.service.ReviewService;
import shop.steamowls.steam.admin.review.vo.ReviewVo;

public class Mmanage implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null || sq.equals("")) {
			ActionForward forward = new ActionForward();
			forward.setPath("/admin");
			forward.setRedirect(true);
			return forward;
		}
		
		MemberService svc = new MemberService();

		
		String pn = request.getParameter("pn");
		if (pn == null || pn == "") {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>location.href='/admin/Mmanage?pn=1';</script>");
			out.close();
			return null;
		}
		
		int page = Integer.parseInt(pn);

		Pagenation pagenation = new Pagenation(page, svc.getMemberCount());
		if (page > pagenation.getTotalPageCount()) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>location.href='/admin/Mmanage?pn=" + pagenation.getTotalPageCount() + "';</script>");
			out.close();
			return null;
		}

		
		ArrayList<MemberVo> list = svc.mManage(pagenation);
		request.setAttribute("pagenation", pagenation);
		request.setAttribute("list", list);

		ActionForward forward = new ActionForward();
		forward.setPath("/views/admin/Mmanage.jsp");
		return forward;
	}
}
