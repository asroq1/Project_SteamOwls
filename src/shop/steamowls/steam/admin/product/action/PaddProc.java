package shop.steamowls.steam.admin.product.action;

import java.io.PrintWriter;
import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.common.LoginManager;
import shop.steamowls.steam.admin.product.service.ProductService;
import shop.steamowls.steam.admin.product.vo.ProductVo;

public class PaddProc implements Action {
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

		String product_name = request.getParameter("product_name");
		String product_detail = request.getParameter("product_detail");
		String product_price = request.getParameter("product_price");
		String product_people = request.getParameter("product_people");
		
		String uploadDir = this.getClass().getResource("").getPath();
		uploadDir = uploadDir.substring(1, uploadDir.indexOf(".metadata")) + "uploadTest/WebContent/uploadImage";
		int maxSize = 350 * 200 * 100;
		String encoding = "UTF-8";
		MultipartRequest multipartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding, new DefaultFileRenamePolicy());
		String fileName = multipartRequest.getOriginalFileName("file");
		String fileRealName = multipartRequest.getFilesystemName("file");
		
		if (product_name == null || product_name.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품 이름을 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}

		if (product_detail == null || product_detail.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품 설명을 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}

		if (product_price == null || product_price.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('상품 이미지를 입력해주세요.'); history.back();</script>");
			out.close();
			return null;
		}

		ProductService svc = new ProductService();
		ProductVo productVo = new ProductVo();
		productVo.setProduct_name(product_name);
		productVo.setProduct_detail(product_detail);
		productVo.setProduct_price(Integer.parseInt(product_price));
		productVo.setProduct_people(Integer.parseInt(product_people));
		productVo.setFileName(fileName);
		productVo.setFileRealName(fileRealName);
		

		if (!svc.pAdd(productVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다.'); history.back();</script>");
			out.close();
			return null;
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/gotoAdmin");
		forward.setRedirect(true);
		return forward;

	}
}
