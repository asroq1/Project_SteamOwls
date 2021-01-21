package shop.steamowls.steam.mypage.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.MypageVo;

public class RmyReviewModifyProc implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String member_sq = lm.getMemberSq(session);

		if (member_sq == null || member_sq.equals("")) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		String review_sq = request.getParameter("review_sq");
		String review_subject = request.getParameter("review_subject");
		String review_content = request.getParameter("review_content");
		String review_star = request.getParameter("review_star");
		
		if(review_sq == null || review_sq.equals("")) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		if(review_subject == null || review_subject.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('리뷰 제목을 입력해주세요.'); location.href='/mypage/Mmodify';</script>");
			out.close();
			return null;
		}
		
		if(review_content == null || review_content.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('리뷰 내용을 입력해주세요.'); location.href='/mypage/Mmodify';</script>");
			out.close();
			return null;
		}
		
		if(review_star == null || review_star.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('리뷰 별점을 확인해주세요.'); location.href='/mypage/Mmodify';</script>");
			out.close();
			return null;
		}
		
		MypageVo mypageVo = new MypageVo();
		mypageVo.setReview_sq(Integer.parseInt(review_sq));
		mypageVo.setReview_star(Double.parseDouble(review_star));
		mypageVo.setReview_subject(review_subject);
		mypageVo.setReview_content(review_content);
		
		MypageService svc = new MypageService();
		if(!svc.rMyReviewModify(mypageVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('리뷰 수정에 실패했습니다.'); history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/mypage/RmyReviewDetail");
		return forward;
	}
}
