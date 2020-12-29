package shop.steamowls.steam.booking.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;

public class Book implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		/* 테스트용 코드 (지우셔도 됩니다.)
		 * String date = request.getParameter("date"); String time =
		 * request.getParameter("time"); String people = request.getParameter("people");
		 * System.out.println(time); System.out.println(date);
		 * System.out.println(people);
		 */
		forward.setPath("/views/booking/booking.jsp");
		return forward;
	}
}
