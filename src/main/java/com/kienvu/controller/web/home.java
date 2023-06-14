package com.kienvu.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kienvu.models.user;
import com.kienvu.utils.JDBCMYSQL_Connect;
import com.kienvu.utils.JDBCSQLRV_Connect;
import com.mysql.cj.protocol.Resultset;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home" })
public class home extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// event handle
		String action = req.getParameter("action");
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		if (action == null) {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
//			return ;

		} else {
			switch (action) {
			case "List": {
				req.setAttribute("method", req.getMethod());
				RequestDispatcher rd = req.getRequestDispatcher("redirect.jsp");
				rd.forward(req, resp);
				break;
			}
			case "AddOrEdit": {
				List<user> list = new ArrayList<>();
				String id = req.getParameter("id");

				String u ="";
				String p ="";
				if (id != null) {

					try {
						String sql = "Select * from user where id = ?";
						Connection conn = JDBCMYSQL_Connect.getConnect();
						PreparedStatement pt = conn.prepareStatement(sql);
						pt.setString(1, id);

						Resultset rs = (Resultset) pt.executeQuery();
						while (((ResultSet) rs).next()) {
							user user = new user();
							user.setUsername(((ResultSet) rs).getString("username"));
							user.setPassword(((ResultSet) rs).getString("password"));
							u =((ResultSet) rs).getString("username");
							p = ((ResultSet) rs).getString("password");
							list.add(user);
						}
						conn.close();
//						 rs.close();
						pt.close();if(list == null) {
							System.out.println("list bi null");
						}
						req.setAttribute("user", list);
						req.setAttribute("u",u );
						req.setAttribute("p", p);
						req.setAttribute("id", id);
						RequestDispatcher rd = req.getRequestDispatcher("form_edit.jsp");
						rd.forward(req, resp);
						
//						RequestDispatcher rd = req.getRequestDispatcher("form_edit.jsp");

					} catch (SQLException |NullPointerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					RequestDispatcher rd = req.getRequestDispatcher("form.jsp");
					rd.forward(req, resp);
				}
				break;
			}
			case "Delete": {
				String id = req.getParameter("id");
				if (id == null) {
					System.out.println("id null :))");
				}
				Connection conn = JDBCMYSQL_Connect.getConnect();
				String sql = "Delete from user where id =?";
				try {
					PreparedStatement pt = conn.prepareStatement(sql);
					pt.setString(1, id);
					pt.executeUpdate();
					//
					conn.close();
					pt.close();
					RequestDispatcher rd = req.getRequestDispatcher("redirect.jsp");
					rd.forward(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "SaveOrUpdate": {
				System.out.println("Method: " + req.getMethod());
				String username = req.getParameter("username");
				String password = req.getParameter("password");
//			user u = new user();

				try {
					Connection conn = JDBCMYSQL_Connect.getConnect();
					if (conn == null) {
						pw.println("ko ket noi dc");
						return;
					}
					user u = new user(username, password);
					String sql = "insert into user(username, password) values (?,?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					ps.executeUpdate();
					//
					conn.close();
					ps.close();
				} catch (SQLException e) {
					// TODO: handle exception
					System.out.println("falied");

				}
				req.setAttribute("method", req.getMethod());
				RequestDispatcher rd = req.getRequestDispatcher("redirect.jsp");
				rd.forward(req, resp);

				break;
			}
			default:
//			throw new IllegalArgumentException("Unexpected value: " + action);
				RequestDispatcher rd = req.getRequestDispatcher("redirect.jsp");
				rd.forward(req, resp);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		resp.setContentType("text/plain");
		String action = req.getParameter("action");
		if (action == null) {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
		switch (action) {
		case "SaveOrUpdate": {
			String id = req.getParameter("id");
			if(id != null) {
				String user = req.getParameter("username");
				String pass = req.getParameter("password");
				Connection conn = JDBCMYSQL_Connect.getConnect();
				String sql = "Update user set username=?, password=? where id=?";
				try {
					PreparedStatement pt = conn.prepareStatement(sql);
					pt.setString(1, user);
					pt.setString(2, pass);
					pt.setString(3, id);
					pt.executeUpdate();
					
					//
					pt.close();
					conn.close();
//					RequestDispatcher rd = req.getRequestDispatcher("redirect.jsp");
//					rd.forward(req, resp);
					req.setAttribute("method", req.getMethod());
					resp.sendRedirect("/Project_Web01/home?action=List");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				try {
					String u = req.getParameter("username");
					String p = req.getParameter("password");
					Connection conn = JDBCMYSQL_Connect.getConnect();
					if (conn == null) {
						System.out.println("Connect null khi save");
					}
					String sql = "insert into user(username, password) values(?,?)";
					PreparedStatement pt = conn.prepareStatement(sql);
					pt.setString(1, u);
					pt.setString(2, p);
					pt.executeUpdate();
					//
					conn.close();
					pt.close();
					req.setAttribute("method", req.getMethod());
					RequestDispatcher rd = req.getRequestDispatcher("redirect.jsp");
					rd.forward(req, resp);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Save or update falied!");
				}
			}
			break;

		}
		default:
			System.out.println("404");
		}
	}
}
