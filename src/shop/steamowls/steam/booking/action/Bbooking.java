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

public class Bbooking implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		LoginManager lm = LoginManager.getInstance();
		String member_sq = lm.getMemberSq(session);

		if (member_sq == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인이 필요합니다.'); location.href='/';</script>");
			out.close();
			return null;
		}
		String booking_date = request.getParameter("booking_date");
		String booking_start = request.getParameter("booking_start");
		String booking_people = request.getParameter("booking_people");

		if (booking_date == null || booking_date.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약 날짜를 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}
		if (booking_start == null || booking_start.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약 시간을 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}
		if (booking_people == null || booking_people.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약 인원수를 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}

		BookingVo bookingVo = new BookingVo();
		bookingVo.setMember_sq(Integer.parseInt(member_sq));
		bookingVo.setBooking_date(booking_date);
		bookingVo.setBooking_start(booking_start);
		bookingVo.setBooking_people(Integer.parseInt(booking_people));

		BookingService svc = new BookingService();
		
		int left_people = 0;
		
		
		// 상품들 보여주기
		ArrayList<BookingVo> list1 = new ArrayList<>();
		list1 = svc.findProduct(bookingVo);
		if (list1 == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다.1'); history.back();</script>");
			out.close();
			return null;

		} 
		
		ArrayList<BookingVo> list2 = new ArrayList<>();
		list2 = svc.getProduct(bookingVo);
		if (list2 == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다.2'); history.back();</script>");
			out.close();
			return null;

		}
		

		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		

		ActionForward forward = new ActionForward();
		forward.setPath("/booking/Pinfo.jsp");
		forward.setRedirect(true);
		return forward;
	}
}
