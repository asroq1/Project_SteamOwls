package shop.steamowls.steam.admin.product.service;

import java.sql.Connection;

import shop.steamowls.steam.admin.admin.dao.AdminDao;
import shop.steamowls.steam.admin.admin.vo.AdminVo;
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

}
