package shop.steamowls.steam.mypage.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.common.Pagenation;
import shop.steamowls.steam.admin.product.vo.ProductVo;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.BoardVo;

public class Question implements Action {
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

		String pn = request.getParameter("pn");
		if (pn == null || pn == "") {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>location.href='/mypage/question?pn=1';</script>");
			out.close();
			return null;
		}
		int page = Integer.parseInt(pn);

		MypageService svc = new MypageService();

		Pagenation pagenation = new Pagenation(page, svc.getBoardCount());
		// 끝 이상으로 넘어가면 마지막 페이지 표시
		if (page > pagenation.getTotalPageCount()) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>location.href='/mypage/question?pn=" + pagenation.getTotalPageCount() + "';</script>");
			out.close();
			return null;
		}

		ArrayList<BoardVo> list = svc.getBoardList(pagenation);
		request.setAttribute("pagenation", pagenation);
		request.setAttribute("list", list);

		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/question.jsp");
		return forward;
	}
}
