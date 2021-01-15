package shop.steamowls.steam.mypage.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.admin.product.service.ProductService;
import shop.steamowls.steam.admin.product.vo.ProductVo;
import shop.steamowls.steam.booking.service.BookingService;
import shop.steamowls.steam.mypage.service.MypageService;

public class Rwriting implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		LoginManager lm = LoginManager.getInstance();
		String member_sq = lm.getMemberSq(session);

		if (member_sq == null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/views/mypage/Rwriting.jsp");
		return forward;
	}
}
