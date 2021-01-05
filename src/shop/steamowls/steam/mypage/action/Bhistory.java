package shop.steamowls.steam.mypage.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.admin.product.service.ProductService;
import shop.steamowls.steam.admin.product.vo.ProductVo;
import shop.steamowls.steam.booking.vo.BookingVo;
import shop.steamowls.steam.member.service.MemberService;
import shop.steamowls.steam.member.vo.MemberVo;
import shop.steamowls.steam.mypage.service.MypageService;
import shop.steamowls.steam.mypage.vo.MypageVo;

public class Bhistory implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/views/member/login.jsp");
			forward.setRedirect(true);
			return forward;
		}

		//
		MypageService svc = new MypageService();
		ArrayList<BookingVo> list = svc.Bhistory(Integer.parseInt(sq));
		request.setAttribute("list", list);

//		String booking_sq = request.getParameter("booking_sq");
//		if (booking_sq == null || booking_sq.equals("")) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.print("<script>alert('예약된 상품이 없습니다.'); history.back();</script>");
//			out.close();
//		}

		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/Bhistory.jsp");
		return forward;
	}
}
