package shop.steamowls.steam.admin.booking.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.admin.booking.service.BookingService;
import shop.steamowls.steam.booking.vo.BookingVo;

public class BmanageProc implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}
		
		String booking_date = request.getParameter("booking_date");
		String booking_start = request.getParameter("booking_start");
		
		if(booking_date == null || booking_date.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약날짜를 선택해주세요.'); history.back();</script>");
			out.close();
			return null;
		}
		
		if(booking_start == null || booking_start.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('예약시간을 선택해주세요.'); history.back();</script>");
			out.close();
			return null;
		}
		
		BookingService svc = new BookingService();
		BookingVo bookingVo = new BookingVo();
		
		bookingVo.setBooking_date(booking_date);
		bookingVo.setBooking_start(booking_start);
		
		ArrayList<BookingVo> list = svc.BmanageProc(bookingVo);
		
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/admin/Bmanage.jsp");
		return forward;
	}
}
