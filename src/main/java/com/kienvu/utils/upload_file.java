package com.kienvu.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.eclipse.tags.shaded.org.apache.bcel.generic.GETFIELD;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = {"/up"})
@MultipartConfig(
		location = "C:\\Workspace\\Project_Web01\\src\\main\\webapp\\img")
public class upload_file extends HttpServlet {
	private static final long serialVersionUID = 6536832892465751113L;

	//
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		
//			Part part = req.getPart("image");
//			String realPath = req.getServletContext().getRealPath("/www.root/images/");
//			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
//			if(!Files.exists(Paths.get(realPath))) {
//				Files.createDirectory(Paths.get(realPath));
//			}
//			part.write(realPath+fileName);
			//Cach moi
			
//			String savePath = "C:\\Workspace\\Project_Web01\\src\\main\\webapp\\www.root\\temp\\";
			
			
			//
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Upload file failed");
		}
//		try {
			Part part2 = req.getPart("image");
			String fileName = Paths.get(part2.getSubmittedFileName()).getFileName().toString();
			System.out.println(part2+" "+fileName);
			part2.write(part2.getSubmittedFileName());
			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("Co loi o cach 2");
//		}
		RequestDispatcher rd = req.getRequestDispatcher("upload.jsp");
		req.setAttribute("img", fileName);
		rd.forward(req, resp);
	}

	

	

}
