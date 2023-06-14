package com.kienvu.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.kienvu.DAO.AdminProductDAO;
import com.kienvu.models.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/product"})
public class ProductController extends HttpServlet {
	String pathDefault ="/Project_Web01/admin/product";
	//[GET] /admin/product/action=?/id=?
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if(action == null) {
			System.out.println("Action null");
		}
		switch (action) {
		case "Index":{
			RequestDispatcher rd = req.getRequestDispatcher("/admin/index.jsp");
			rd.forward(req, resp);
			break;
		}
		case "AddOrEdit": {
			int id = Integer.parseInt( req.getParameter("id"));
			if(id ==0) {//form add
				RequestDispatcher rd = req.getRequestDispatcher("/admin/formCreateProduct.jsp");
				rd.forward(req, resp);
			}else {
				
			}
			break;
			
		}
		default:
			RequestDispatcher rd = req.getRequestDispatcher("/admin/index.jsp");
			rd.forward(req, resp);
		}

	}
	//[POST] /admin/product/action=?/id=?
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		if(action == null) {
			System.out.println("Acction null");
		}
		switch (action) {
		case "SaveOrUpdate":{
			//get param form client
			int id = Integer.parseInt(req.getParameter("id"));
			if(id == 0) { //yyyy/MM/dd HH:mm:ss
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
				LocalDateTime date = LocalDateTime.now(); 
				//
				int check =0;
				Product p = new Product();
				p.setProduct_name(req.getParameter("pName"));
				p.setProduct_describe(req.getParameter("pDescribe"));
				p.setPrice(new BigDecimal(req.getParameter("pPrice")));
				p.setCreate_at(date.toString());
				p.setProduct_status(Boolean.parseBoolean(req.getParameter("pStatus")));
				
				check  = AdminProductDAO.getInstance().save(p);
				
				if(check !=0) {
					resp.sendRedirect(pathDefault+"?action=Index");
//					RequestDispatcher rd = req.getRequestDispatcher("/admin/index.jsp");
//					rd.forward(req, resp);
				}else {
					System.out.println("failed to add new poduct");
					RequestDispatcher rd = req.getRequestDispatcher("/admin/index.jsp");
					rd.forward(req, resp);
				}
			}else { //case: have parameter
				
			}
			break;
		}
		default:
			RequestDispatcher rd = req.getRequestDispatcher("admin/index.jsp");
			rd.forward(req, resp);
		}
	}
	
}
