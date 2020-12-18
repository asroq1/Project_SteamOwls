package shop.steamowls.steam.member.action;

import static shop.steamowls.common.RegExp.REGEXP_NAME;
import static shop.steamowls.common.RegExp.REGEXP_TEL;

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

public class ForgotIdProc implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");

		//jsp에서 받아오는 값
		MemberVo memberVo = new MemberVo();
		memberVo.setName(name);
		memberVo.setTel(tel);

		MemberService svc = new MemberService();
		
		//DB에서 받아오는 값
		MemberVo vo = svc.forgotId(memberVo);
		if (vo == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('이름, 전화번호를 확인하시오.'); history.back();</script>");
			out.close();
			return null;
		}
		request.setAttribute("vo",vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/member/checkId.jsp");
		return forward;
	}
}
