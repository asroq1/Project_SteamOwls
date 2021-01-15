package shop.steamowls.steam.mypage.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.BoardVo;

public class QDetail implements Action{
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
		
		String board_sq = request.getParameter("board_sq");
		
		
		MypageService svc = new MypageService();
		
		if (svc.qDetail(board_sq) == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상세페이지 이동에 실패하였습니다.'); history.back();</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("vo", svc.qDetail(board_sq));
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/QDetail.jsp");
		return forward;
	}
}
