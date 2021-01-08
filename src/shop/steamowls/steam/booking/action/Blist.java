package shop.steamowls.steam.booking.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.booking.service.BookingService;
import shop.steamowls.steam.booking.vo.BookingVo;

public class Blist implements Action {
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

		BookingVo bookingVo = new BookingVo();
		bookingVo.setMember_sq(Integer.parseInt(sq));
		bookingVo.setBooking_date(booking_date);
		bookingVo.setBooking_start(booking_start);
		bookingVo.setBooking_people(Integer.parseInt(booking_people));

		BookingVo bookingInfoVo = new BookingVo();
		bookingInfoVo.setBooking_date(booking_date);
		bookingInfoVo.setBooking_start(booking_start);
		bookingInfoVo.setBooking_people(Integer.parseInt(booking_people));

		BookingService svc = new BookingService();
		ArrayList<BookingVo> list = new ArrayList<BookingVo>();
		list = svc.findProduct();
		if (list == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다.'); history.back();</script>");
			out.close();
			return null;
		}

		request.setAttribute("list", list);
		request.setAttribute("bookingInfoVo", bookingInfoVo);

		ActionForward forward = new ActionForward();
		forward.setPath("/views/booking/Blist.jsp");
		return forward;

	}
}
