package shop.steamowls.steam.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.BCrypt;
import shop.steamowls.common.LoginManager;
import shop.steamowls.common.RegExp;
import shop.steamowls.steam.member.service.MemberService;
import shop.steamowls.steam.member.vo.MemberVo;

import static shop.steamowls.common.RegExp.REGEXP_ID;
import static shop.steamowls.common.RegExp.REGEXP_PW;
import static shop.steamowls.common.RegExp.REGEXP_NAME;
import static shop.steamowls.common.RegExp.REGEXP_TEL;

import java.io.PrintWriter;

import static shop.steamowls.common.RegExp.REGEXP_GENDER;
import static shop.steamowls.common.RegExp.REGEXP_SMS_FL;

public class ResetPw implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq != null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}

		String pw = request.getParameter("pw");
		String cpw = request.getParameter("cpw");
		sq = request.getParameter("sq");

		if (RegExp.isValidExp(pw, REGEXP_PW) || RegExp.isValidExp(cpw, REGEXP_PW)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('정보를 올바르게 입력해 주세요.'); location.href='/';</script>");
			out.close();
			return null;
		}
		
		//문자열 비교
		if(!pw.equals(cpw)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='/';</script>");
			out.close();
			return null;
		}
		
		//restPw.jsp에서 가저온 memberVo의 sq부르기
		MemberVo memberVo = new MemberVo();
		memberVo.setSq(Integer.parseInt(sq));
		
		//이전 memberVo에 있던 비밀번호를 새 비밀번호로 암호화해서 덮어쓰기
		memberVo.setPw(BCrypt.hashpw(pw,  BCrypt.gensalt(10)));
		
		
		MemberService svc = new MemberService();
		
		if(!svc.resetPw(memberVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('비밀번호 재설정에 실패하였습니다.'); history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/views/member/login.jsp");
		forward.setRedirect(true);
		return forward;
	}
}
