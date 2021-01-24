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
import shop.steamowls.steam.booking.service.BookingService;
import shop.steamowls.steam.booking.vo.BookingVo;
import shop.steamowls.steam.mypage.service.MypageService;

public class BCancel implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);
		String booking_sq = request.getParameter("booking_sq");


		if (sq == null || sq.equals("")) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		if (booking_sq == null || booking_sq.equals("")) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		BookingVo bookingVo = new BookingVo();
		bookingVo.setBooking_sq(Integer.parseInt(booking_sq));
		
		MypageService svc = new MypageService();
		BookingVo vo = svc.bCancel(bookingVo);
		request.setAttribute("vo", vo);
		

		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/Bcancel.jsp");
		return forward;
	}
}
