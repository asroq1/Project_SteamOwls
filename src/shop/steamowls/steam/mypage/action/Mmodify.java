package shop.steamowls.steam.mypage.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.member.service.MemberService;
import shop.steamowls.steam.member.vo.MemberVo;

public class Mmodify implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// �α��ο��� �� �߸��� ����
		// ���ǿ� sq ������ �ֱ�
		HttpSession session = request.getSession();

		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		//jsp���� ������ �ޱ�
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		
		MemberVo memberVo = new MemberVo();
		memberVo.setSq(Integer.parseInt(sq));
		memberVo.setName(name);
		memberVo.setPw(pw);
		memberVo.setTel(tel);
		
		MemberService svc = new MemberService();
		
		if(!svc.modify(memberVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('ȸ������������ �����Ͽ����ϴ�.'); history.back();</script>");
			out.close();
			return null;
		}
		
		lm.removeSession(sq);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/Mmodify.jsp");
		return forward;
	}
}
