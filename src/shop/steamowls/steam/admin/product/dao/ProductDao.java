package shop.steamowls.steam.admin.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.steamowls.steam.admin.admin.vo.AdminVo;
import shop.steamowls.steam.admin.product.vo.ProductVo;

import static shop.steamowls.common.JdbcUtil.close;

public class ProductDao {
	private Connection con;

	public ProductDao() {

	}

	private static class LazyHolder {
		private static final ProductDao INSTANCE = new ProductDao();
	}

	public static ProductDao getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	
	public int pAdd(ProductVo productVo) {

		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			pstmt = con.prepareStatement("insert into owls_product_tb(product_price, product_name, product_detail) values(?, ?, ?)");
			pstmt.setString(1, productVo.getProduct_name());
			pstmt.setString(2, productVo.getProduct_detail());
			pstmt.setInt(3, productVo.getProduct_price());

			count = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

	

}
