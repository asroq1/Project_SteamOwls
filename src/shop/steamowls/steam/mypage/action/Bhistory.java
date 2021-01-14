package shop.steamowls.steam.mypage.action;

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

public class Bhistory implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);
		String booking_date = request.getParameter("booking_date");
		String booking_start = request.getParameter("booking_start");

		if (sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		BookingVo bookingVo = new BookingVo();
		bookingVo.setMember_sq(Integer.parseInt(sq));
		bookingVo.setBooking_date(booking_date);
		bookingVo.setBooking_start(booking_start);
		
		MypageService svc = new MypageService();
		ArrayList<BookingVo> list = svc.bDetail(bookingVo);
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/BHistory.jsp");
		return forward;
	}
}
