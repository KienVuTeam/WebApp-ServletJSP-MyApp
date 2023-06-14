package com.kienvu.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.kienvu.IDAO.I_CRUD;
import com.kienvu.models.Product;
import com.kienvu.utils.JDBCMYSQL_Connect;

public class AdminProductDAO implements I_CRUD<Product>{
	
	private static AdminProductDAO instance;
	private AdminProductDAO() {}
	
	public static AdminProductDAO getInstance() {
		if(instance == null) {
			instance = new AdminProductDAO();
		}
		return instance;
	}
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Product t) {
		// TODO Auto-generated method stub
		//
//		BigDecimal z = BigDecimal.
		Connection conn = JDBCMYSQL_Connect.getConnect();
		String sql = "insert into product(product_name, product_describe, product_status, price, create_at) values(?,?,?,?,?)";
		PreparedStatement pt = null;
		try {
			int statusSave = 0;
			pt = conn.prepareStatement(sql);
			pt.setString(1, t.getProduct_name());
			pt.setString(2, t.getProduct_describe());
			pt.setBoolean(3, t.getProduct_status());
//			pt.setString(4, t.getImage());
			pt.setBigDecimal(4, t.getPrice());
			pt.setString(5, t.getCreate_at());
			//
			statusSave = pt.executeUpdate();
			conn.close();
			pt.close();
			return statusSave;
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("don't create product");
		}
		
		return 0;
	}

	@Override
	public void update(Product t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	public void hello() {
		
	}
}
