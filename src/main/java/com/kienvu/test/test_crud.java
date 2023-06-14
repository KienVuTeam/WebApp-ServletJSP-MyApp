package com.kienvu.test;

import java.io.IOException;

import com.kienvu.DAO.AccountAdminDAO;
import com.kienvu.models.AccountAdmin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/testdao"})
public class test_crud extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		boolean check =false;
//		AccountAdmin ad= new AccountAdmin("admin3", "password", true);
//		check = AccountAdminDAO.getInstance().save(ad);
//		if(check = true) {
//			System.out.println("add success");
//			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//			rd.forward(req, resp);
//		}else {
//			System.out.println("failed");
//		}
		
		//-----------------------------demo delete
		boolean check = false;
		check = AccountAdminDAO.getInstance().delete(3);
		if(check = true) {
			System.out.println("delete success");
			RequestDispatcher rd = req.getRequestDispatcher("redirect.jsp");
			rd.forward(req, resp);
		}else {
			System.out.println("failed");
		}
	}
}
