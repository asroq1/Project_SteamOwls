package shop.steamowls.steam.ajax;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.RegExp;
import shop.steamowls.steam.member.service.MemberService;
import shop.steamowls.steam.member.vo.MemberVo;

import static shop.steamowls.common.RegExp.REGEXP_ID;

public class AjaxCheckId  implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");

		// 아이디 정규표현식
		if (!RegExp.isValidExp(id, REGEXP_ID)) {

		}
		
		MemberVo memberVo = new MemberVo();
		memberVo.setId(id);
		
		MemberService svc = new MemberService();
		request.setAttribute("isTrue", svc.checkId(id));
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/ajax/common.jsp");
		return forward;
	}
}