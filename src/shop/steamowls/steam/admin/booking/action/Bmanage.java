package shop.steamowls.steam.admin.booking.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.admin.booking.service.BookingService;
import shop.steamowls.steam.booking.vo.BookingVo;
import shop.steamowls.steam.mypage.service.MypageService;

public class Bmanage implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/views/member/login.jsp");
			forward.setRedirect(true);
			return forward;
		}

		//BookingVo 리스트로 불러오긩
		BookingService svc = new BookingService();
		ArrayList<BookingVo> list = svc.Bmanage();
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/admin/Bmanage.jsp");
		return forward;
	}
}
