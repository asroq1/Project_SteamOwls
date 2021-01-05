package shop.steamowls.steam.booking.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.booking.service.BookingService;
import shop.steamowls.steam.booking.vo.BookingVo;

public class Pinfo implements Action {
	@Override
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
		String product_sq = request.getParameter("product_sq");
		String product_name = request.getParameter("product_name");
		String product_price = request.getParameter("product_price");

		if (booking_date == null || booking_date.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약날짜 오류'); history.back();</script>");
			out.close();
			return null;
		}

		if (booking_start == null || booking_start.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약시간 오류'); history.back();</script>");
			out.close();
			return null;
		}

		if (product_name == null || product_name.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품이름 오류'); history.back();</script>");
			out.close();
			return null;
		}

		if (booking_people == null || booking_people.equals("") || Integer.parseInt(booking_people) == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약인원 오류'); history.back();</script>");
			out.close();
			return null;
		}

		if (product_sq == null || product_sq.equals("") || Integer.parseInt(product_sq) == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품시퀀스 오류'); history.back();</script>");
			out.close();
			return null;
		}

		if (product_price == null || product_price.equals("") || Integer.parseInt(product_price) == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품가격 오류'); history.back();</script>");
			out.close();
			return null;
		}

		BookingVo bookingVo = new BookingVo();
		bookingVo.setMember_sq(Integer.parseInt(sq));
		bookingVo.setBooking_date(booking_date);
		bookingVo.setBooking_start(booking_start);
		bookingVo.setBooking_people(Integer.parseInt(booking_people));
		bookingVo.setProduct_sq(Integer.parseInt(product_sq));
		bookingVo.setProduct_name(product_name);
		bookingVo.setProduct_price(Integer.parseInt(product_price));

		BookingService svc = new BookingService();
		
		if(!svc.pInfo(bookingVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다..'); history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/views/booking/Pinfo.jsp");
		return forward;
	}
}
