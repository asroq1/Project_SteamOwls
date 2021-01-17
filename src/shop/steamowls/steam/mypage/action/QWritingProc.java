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

public class QWritingProc implements Action {
	@Override
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

		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("content");

		if (board_subject == null || board_subject.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('제목을 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}

		if (board_content == null || board_content.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('내용을 작성해주세요.'); history.back();</script>");
			out.close();
			return null;
		}

		BoardVo boardVo = new BoardVo();
		boardVo.setMember_sq(Integer.parseInt(sq));
		boardVo.setBoard_subject(board_subject);
		boardVo.setBoard_content(board_content);

		MypageService svc = new MypageService();

		if (!svc.QWriting(boardVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('게시물 등록에 실패하셨습니다.'); history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/mypage/Question");
		return forward;
	}
}