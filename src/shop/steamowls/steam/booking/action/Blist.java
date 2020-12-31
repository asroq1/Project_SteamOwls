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
		String product_sq = request.getParameter("product_sq");
		
		

		ActionForward forward = new ActionForward();
		forward.setPath("/views/booking/Binfo.jsp");
		return forward;

	}
}
