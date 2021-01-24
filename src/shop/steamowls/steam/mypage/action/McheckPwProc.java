package shop.steamowls.steam.mypage.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.BCrypt;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.member.service.MemberService;
import shop.steamowls.steam.member.vo.MemberVo;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.MypageVo;

public class McheckPwProc implements Action {
	@SuppressWarnings("unlikely-arg-type")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 로그인여부 및 잘못된 접근
		// 세션에 sq 가지고 있기
		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}

		// jsp에서 입력한 비밀번호 부르기
		String pw = request.getParameter("pw");

		MypageVo mypageVo = new MypageVo();
		mypageVo.setSq(Integer.parseInt(sq));
		// memberVo.setPw(BCrypt.hashpw(pw, BCrypt.gensalt(10)));

		// 비밀번호 확인
		// 기존 회원정보 불러오기
		MypageService svc = new MypageService();
		MypageVo vo = svc.mCheckPw(mypageVo);

		if (vo == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('정보를 가져오지 못했습니다.'); history.back();</script>");
			out.close();
			return null;
		}

		if (!BCrypt.checkpw(pw, vo.getPw())) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('비밀번호가 틀렸습니다.'); history.back();</script>");
			out.close();
			return null;
		}

		// 세션에 memberVo넣기
		request.setAttribute("vo", vo);

		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/Mmodify.jsp");
		return forward;
	}
}