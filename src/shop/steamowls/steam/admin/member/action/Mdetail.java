package shop.steamowls.steam.admin.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.admin.member.service.MemberService;
import shop.steamowls.steam.admin.member.vo.MemberVo;
import shop.steamowls.steam.admin.review.service.ReviewService;
import shop.steamowls.steam.admin.review.vo.ReviewVo;

public class Mdetail implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null || sq.equals("")) {
			ActionForward forward = new ActionForward();
			forward.setPath("/admin");
			forward.setRedirect(true);
			return forward;
		}
		
		String member_sq = request.getParameter("member_sq");
		if(member_sq == null || member_sq.equals("")) {
			ActionForward forward = new ActionForward();
			forward.setPath("/admin/Mmanage");
			forward.setRedirect(true);
			return forward;
		}
		
		MemberVo memberVo = new MemberVo();
		memberVo.setSq(Integer.parseInt(member_sq));
		
		MemberService svc = new MemberService();
		MemberVo vo = svc.mDetail(memberVo);
		
		request.setAttribute("vo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/admin/Mdetail.jsp");
		return forward;
	}
}
