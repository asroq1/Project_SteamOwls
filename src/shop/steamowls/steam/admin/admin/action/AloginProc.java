package shop.steamowls.steam.admin.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.BCrypt;
import shop.steamowls.steam.admin.admin.service.AdminService;
import shop.steamowls.steam.admin.admin.vo.AdminVo;

public class AloginProc implements Action {
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

		AdminService svc = new AdminService();

		AdminVo adminVo = new AdminVo();
		adminVo.setId(id);
		adminVo.setPw(BCrypt.hashpw(pw, BCrypt.gensalt(10)));

		AdminVo vo = svc.adminLogIn(adminVo);
		if (vo == null || !BCrypt.checkpw(pw, vo.getPw())) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 정보를 입력하세요'); history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/views/admin/gotoAdmin.jsp");
		forward.setRedirect(true);
		return forward;
	}
}
