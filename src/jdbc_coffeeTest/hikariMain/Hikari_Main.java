package jdbc_coffeeTest.hikariMain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc_coffeeTest.dao.ProductDaoImpl;
import jdbc_coffeeTest.dto.Product;
import jdbc_coffeeTest.hikariDS.Hikari_DataSource;


public class Hikari_Main {
	
	public static void main(String[] args)  {
			
		try(Connection con = Hikari_DataSource.getConnection()){
			ProductDaoImpl dao = ProductDaoImpl.getInstance();
			//dao.selectProductByAll(con);
			
			List<Product> list = dao.selectProductByAll(con);
			for (Product p : list) {
				System.out.println(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
