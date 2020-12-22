package shop.steamowls.steam.admin.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.admin.product.service.ProductService;
import shop.steamowls.steam.admin.product.vo.ProductVo;

public class PsellingButton implements Action{
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
		
		String product_sq = request.getParameter("product_sq");
		
		if(product_sq == null){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품이 없습니다.'); history.back();</script>");
			out.close();
			return null;
		}
		
		ProductVo productVo = new ProductVo();
		productVo.setProduct_sq(Integer.parseInt(product_sq));
		
		ProductService svc = new ProductService();
		if (!svc.pSellingButton(productVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품판매시작을 실패했습니다.'); history.back();</script>");
			out.close();
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/gotoAdmin");
		forward.setRedirect(true);
		return forward;
	}
}
