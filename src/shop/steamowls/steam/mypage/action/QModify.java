package shop.steamowls.steam.mypage.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.BoardVo;

public class QModify implements Action{
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
		
		BoardVo boardVo = new BoardVo();
		boardVo.setMember_sq(Integer.parseInt(sq));
		boardVo.setBoard_sq(Integer.parseInt(board_sq));

		MypageService svc = new MypageService();
		
		request.setAttribute("vo", svc.qModify(boardVo));

		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/QModify.jsp");
		return forward;
	}
}
