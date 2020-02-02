package jdbc_coffeeTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_coffeeTest.dto.Product;

public class ProductDaoImpl implements ProductDao {
	
	private static final ProductDaoImpl instance = new ProductDaoImpl();
	
	
	
	private ProductDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProductDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Product> selectProductByAll(Connection con) throws SQLException {
		String sql = "select code, name from product";
		List<Product> list = new ArrayList<Product>();
		try(PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				list.add(getProduct(rs));
			}
			
		}
		return list;
	}

	private Product getProduct(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String name = rs.getString("name");
		return new Product(code, name);
	}

	@Override
	public int insertProduct(Connection con, Product prd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProduct(Connection con, Product prd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(Connection con, Product prd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
