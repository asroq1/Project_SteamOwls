package shop.steamowls.steam.admin.product.action;

import java.io.PrintWriter;
import java.util.Enumeration;
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

		// 파일이 저장되는 경로
		String product_imagePath = request.getSession().getServletContext().getRealPath("fildFolder");

		int size = 1024 * 1024 * 10;// 저장가능한 파일 크기
		String product_image = "";// 업로드한 파일의 이름(이름이 변경될 수 있음)
		String product_originalImage = "";// 이름이 변경되기 전 실제 파일 이름

		try {
			MultipartRequest multi = new MultipartRequest(request, product_imagePath, size, "UTF-8", new DefaultFileRenamePolicy());

			Enumeration files = multi.getFileNames();
			String str = (String) files.nextElement();// 파일 이름을 받아와 string으로 저장

			product_image = multi.getFilesystemName(str);// 업로드 된 파일 이름 가져옴
			product_originalImage = multi.getOriginalFileName(str);// 원래의 파일이름 가져옴
		} catch (Exception e) {
			e.printStackTrace();
		}

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
		productVo.setProduct_image(product_image);
		productVo.setProduct_originalImage(product_originalImage);
		productVo.setProduct_imagePath(product_imagePath);

		if (!svc.pAdd(productVo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('잘못된 접근입니다.11'); history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/admin/gotoAdmin");
		forward.setRedirect(true);
		return forward;

	}
}
