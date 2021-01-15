package shop.steamowls.steam.mypage.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.MypageVo;

public class RmyreviewDetail implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String member_sq = lm.getMemberSq(session);

		if (member_sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		String review_sq = request.getParameter("review_sq");
		if(review_sq == null || review_sq.equals("") ) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		MypageVo mypageVo = new MypageVo();
		mypageVo.setReview_sq(Integer.parseInt(review_sq));

		MypageService svc = new MypageService();
		MypageVo vo = new MypageVo();
		vo = svc.rMyReviewDetail(mypageVo);
		
		request.setAttribute("vo", vo);

		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/RmyReviewDetail.jsp");
		return forward;
	}
}
