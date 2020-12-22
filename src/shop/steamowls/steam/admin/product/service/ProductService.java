package shop.steamowls.steam.admin.product.service;

import java.sql.Connection;
import java.util.ArrayList;

import shop.steamowls.steam.admin.product.dao.ProductDao;
import shop.steamowls.steam.admin.product.vo.ProductVo;

import static shop.steamowls.common.JdbcUtil.*;

public class ProductService {

	public boolean pAdd(ProductVo productVo) {
		ProductDao productDao = ProductDao.getInstance();
		Connection con = getConnection();
		productDao.setConnection(con);

		int count = productDao.pAdd(productVo);

		boolean isSuccess = false;
		if (count > 0) {
			commit(con);
			isSuccess = true;
		} else {
			rollback(con);
			isSuccess = false;
		}
		close(con);
		return isSuccess;
	}
	
	public ArrayList<ProductVo> getProductList() {
		ProductDao dao = ProductDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		ArrayList<ProductVo> list = dao.getProductList();
		close(con);
		return list;
	}
	
	public boolean pDelete(ProductVo productVo) {
		ProductDao productDao = ProductDao.getInstance();
		Connection con = getConnection();
		productDao.setConnection(con);

		int count = productDao.pDelete(productVo);
		boolean isSuccess = false;
		if (count > 0) {
			commit(con);
			isSuccess = true;
		} else {
			rollback(con);
			isSuccess = false;
		}
		close(con);
		return isSuccess;
	}

}
