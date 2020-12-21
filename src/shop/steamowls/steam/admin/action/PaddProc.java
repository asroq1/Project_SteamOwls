package shop.steamowls.steam.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.admin.service.AdminService;
import shop.steamowls.steam.admin.vo.AdminVo;

public class PaddProc implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		LoginManager lm = LoginManager.getInstance();
		String sq = lm.getMemberSq(session);

		if (sq != null) {
			ActionForward forward = new ActionForward();
			forward.setPath("/");
			forward.setRedirect(true);
			return forward;
		}

		String product_name = request.getParameter("product_name");
		String product_detail = request.getParameter("product_detail");
		String product_price = request.getParameter("product_price");
		String file_path = request.getParameter("file_path");
		String thumbnail_path = request.getParameter("thumbnail_path");
		
		if(product_name == null || product_name.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품 이름을 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}
		
		if(product_detail == null || product_detail.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품 설명을 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}
		
		if(product_price == null || product_price.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품 이미지를 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}
		
		AdminService svc = new AdminService();
		AdminVo adminVo = new AdminVo();
		adminVo.setProduct_name(product_name);
		adminVo.setProduct_detail(product_detail);
		adminVo.setProduct_price(Integer.parseInt(product_price));
		adminVo.setFile_path(file_path);
		adminVo.setThumbnail_path(thumbnail_path);
		
		if(!svc.)
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/");
		forward.setRedirect(true);
		return forward;
	}
}
