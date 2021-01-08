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

public class Binfo implements Action {
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

		if (booking_date == null || booking_date.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약날짜를 입력해주세요'); history.back();</script>");
			out.close();
			return null;
		}

		if (booking_start == null || booking_start.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약시간을 입력해주세요'); history.back();</script>");
			out.close();
			return null;
		}

		if (booking_people == null || booking_people.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약인원수를 입력해주세요'); history.back();</script>");
			out.close();
			return null;
		}

		if (product_sq == null || product_sq.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품을 선택해주세요.'); history.back();</script>");
			out.close();
			return null;
		}

		BookingVo bookingVo = new BookingVo();
		bookingVo.setMember_sq(Integer.parseInt(sq));
		bookingVo.setBooking_date(booking_date);
		bookingVo.setBooking_start(booking_start);
		bookingVo.setBooking_people(Integer.parseInt(booking_people));
		bookingVo.setProduct_sq(Integer.parseInt(product_sq));

		BookingService svc = new BookingService();
		if (svc.bList(bookingVo) > 4) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약인원이 꽉 찼습니다.'); history.back();</script>");
			out.close();
			return null;
		} else if (svc.bList(bookingVo) <= 4 && svc.bList(bookingVo) > bookingVo.getBooking_people()) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('최대인원 4명중 " + svc.bList(bookingVo)
					+ "명이 찼습니다. 예약인원을 맞춰주세요'); history.back();</script>");
			out.close();
			return null;
		}

		BookingVo productInfoVo = svc.bListFindProduct(Integer.parseInt(product_sq));

		request.setAttribute("bookingVo", bookingVo);
		request.setAttribute("productInfoVo", productInfoVo);

		ActionForward forward = new ActionForward();
		forward.setPath("/views/booking/Binfo.jsp");
		return forward;

	}
}