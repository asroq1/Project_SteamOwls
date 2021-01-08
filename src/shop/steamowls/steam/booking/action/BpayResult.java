package shop.steamowls.steam.booking.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.booking.vo.BookingVo;

public class BpayResult implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null || sq.equals("")) {
			ActionForward forward = new ActionForward();
			forward.setPath("/views/member/login.jsp");
			forward.setRedirect(true);
			return forward;
		}

		String booking_date = request.getParameter("booking_date");
		String booking_start = request.getParameter("booking_start");
		String booking_people = request.getParameter("booking_people");
		String product_price = request.getParameter("product_price");
		String product_name = request.getParameter("product_name");

		BookingVo bookingVo = new BookingVo();

		bookingVo.setBooking_date(booking_date);
		bookingVo.setBooking_start(booking_start);
		bookingVo.setBooking_people(Integer.parseInt(booking_people));
		bookingVo.setProduct_price(Integer.parseInt(product_price));
		bookingVo.setProduct_name(product_name);

		request.setAttribute("bookingVo", bookingVo);

		ActionForward forward = new ActionForward();
		forward.setPath("/views/booking/BpayResult.jsp");
		return forward;
	}
}
