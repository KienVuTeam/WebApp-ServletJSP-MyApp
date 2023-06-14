package com.kienvu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.kienvu.IDAO.I_CRUD;
import com.kienvu.models.AccountAdmin;
import com.kienvu.utils.JDBCMYSQL_Connect;

public class AccountAdminDAO implements I_CRUD<AccountAdmin>{

	private static AccountAdminDAO instance = null;
	private  AccountAdminDAO() {
		
	}
	public static AccountAdminDAO getInstance() {
		if(instance == null) {
			instance = new AccountAdminDAO();
		}
		return instance;
	}
	
	
	@Override
	public List<AccountAdmin> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(AccountAdmin t) {
		// TODO Auto-generated method stub
		Connection conn = JDBCMYSQL_Connect.getConnect();
		PreparedStatement pt = null;
		try {
			String sql = "Insert into account_admin(username, password, status) values(?,?,?)";
			pt = conn.prepareStatement(sql);
			pt.setString(1, t.getUsername());
			pt.setString(2, t.getPassword());
			pt.setBoolean(3, t.getStatus());
			
			//
			pt.execute();
			return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 1;
		
		
	}

	@Override
	public void update(AccountAdmin t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int id) {
		Connection conn = JDBCMYSQL_Connect.getConnect();
		String sql ="Delete from account_admin where id = ?";
		PreparedStatement pt = null;
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, id);
			pt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}



}
