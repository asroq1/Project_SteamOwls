package shop.steamowls.steam.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.BCrypt;
import shop.steamowls.steam.member.service.MemberService;
import shop.steamowls.steam.member.vo.MemberVo;

public class AloginProc implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		if (RegExp.isEmpty(id) || RegExp.isEmpty(pw)) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.print("<script>alert('�߸��� �����Դϴ�..'); location.href='/';</script>");
//			out.close();
//			return null;
//		}
		
		MemberService svc = new MemberService();

		MemberVo memberVo = new MemberVo();
		memberVo.setId(id);
		memberVo.setPw(BCrypt.hashpw(pw,  BCrypt.gensalt(10)));
		
		
		MemberVo vo = svc.adminLogIn(memberVo);
		if(memberVo == null || !BCrypt.checkpw(pw, vo.getPw())) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('�α��� ������ �Է��ϼ���'); history.back();</script>");
			out.close();
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/admin/gotoAdmin.jsp");
		forward.setRedirect(true);
		return forward;
	}
}
