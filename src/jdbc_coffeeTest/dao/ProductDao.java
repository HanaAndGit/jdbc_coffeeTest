package jdbc_coffeeTest.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc_coffeeTest.dto.Product;

public interface ProductDao {
	List<Product> selectProductByAll(Connection con) throws SQLException;
	int insertProduct(Connection con, Product prd) throws SQLException;
	int updateProduct(Connection con, Product prd) throws SQLException;
	int deleteProduct(Connection con, Product prd) throws SQLException;

}
