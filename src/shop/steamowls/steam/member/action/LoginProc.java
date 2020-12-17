package shop.steamowls.steam.member.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.BCrypt;
import shop.steamowls.common.LoginManager;
import shop.steamowls.common.RegExp;
import shop.steamowls.steam.member.service.MemberService;
import shop.steamowls.steam.member.vo.MemberVo;

public class LoginProc implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		if (RegExp.isEmpty(id) || RegExp.isEmpty(pw)) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.print("<script>alert('잘못된 접근입니다..'); location.href='/';</script>");
//			out.close();
//			return null;
//		}
		
		MemberService svc = new MemberService();

		MemberVo memberVo = new MemberVo();
		memberVo.setId(id);
		memberVo.setPw(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
		
		MemberVo vo = svc.logIn(memberVo);
		if(memberVo == null || !BCrypt.checkpw(pw, vo.getPw())) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 정보를 입력하세요'); history.back();</script>");
			out.close();
			return null;
		}
		
		
		LoginManager lm = LoginManager.getInstance();
		lm.setSession(request.getSession(), Integer.toString(vo.getSq()));
		
		ActionForward forward = new ActionForward();
		forward.setPath("/");
		forward.setRedirect(true);
		return forward;
	}
}
