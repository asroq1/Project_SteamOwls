package shop.steamowls.steam.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.common.RegExp;
import shop.steamowls.steam.member.service.MemberService;
import shop.steamowls.steam.member.vo.MemberVo;

public class ForgotPwProc implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		//잘못된 경로 확인
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		if (RegExp.isEmpty(id) || RegExp.isEmpty(name) || RegExp.isEmpty(tel)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다..'); location.href='/';</script>");
			out.close();
			return null;
		}
		
		//각 데이터 로드
		MemberVo memberVo = new MemberVo();
		MemberService svc = new MemberService();
		
		//vo에 데이터 세팅
		memberVo.setId(id);
		memberVo.setName(name);
		memberVo.setTel(tel);
		
		//존재하지 않는 아이디 회원정보 확인
		if(svc.forgotPw(memberVo) == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('회원정보가 없습니다.'); history.back();</script>");
			out.close();
			return null;
		}
		//dao에서 새로 넣은 memberVo 넣기
		MemberVo vo = svc.forgotPw(memberVo);
		
		//세션에 memberVo넣기
		request.setAttribute("vo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/member/resetPw.jsp");
		//memberVo의 값을 reset.jsp로 보내야 하므로 setRirect를 쓰면 안됨
		//forward.setRedirect(true);
		return forward;
		
		
	}
}
