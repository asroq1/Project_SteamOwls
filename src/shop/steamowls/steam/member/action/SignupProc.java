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

public class SignupProc implements Action {
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

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String cpw = request.getParameter("cpw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String sms_fl = request.getParameter("sms_fl");
		String info_fl = request.getParameter("info_fl");

		if (RegExp.isValidExp(id, REGEXP_ID) || RegExp.isValidExp(pw, REGEXP_PW) || RegExp.isValidExp(name, REGEXP_NAME)
				|| RegExp.isValidExp(tel, REGEXP_TEL) || RegExp.isValidExp(gender, REGEXP_GENDER)
				|| RegExp.isValidExp(sms_fl, REGEXP_SMS_FL)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('정보를 올바르게 입력해 주세요.'); history.back();</script>");
			out.close();
			return null;
		}

		
		if(info_fl == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('개인정보공개여부를 체크해주세요.'); location.href='/';</script>");
			out.close();
			return null;
		}

		MemberVo memberVo = new MemberVo();
		Boolean smsFl = Boolean.parseBoolean(sms_fl);
		
		memberVo.setId(id);
		memberVo.setPw(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
		memberVo.setName(name);
		memberVo.setTel(tel);
		memberVo.setGender(gender);
		memberVo.setSms_fl(smsFl);
		
		MemberService svc = new MemberService();

		
		if(!svc.signUp(memberVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다..'); history.back();</script>");
			out.close();
			return null;
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/member/login.jsp");
		forward.setRedirect(true);
		return forward;
	}
}
