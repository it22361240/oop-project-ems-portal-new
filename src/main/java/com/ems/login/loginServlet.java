package com.ems.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;



@WebServlet("/login")
public class  loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.print("working....    ");
//		System.out.println("hwllos im done   ");
//		out.print("user name - "+ request.getParameter("username"));
//		out.print("password - " + request.getParameter("password"));
		
		
		// this is create the another jsp file and send data to this file
		
//		RequestDispatcher dip = request.getRequestDispatcher("registration.jsp");
//		request.setAttribute("username", request.getParameter("username"));
//		request.setAttribute("password", request.getParameter("password"));	
//		dip.forward(request, response);

		
		// working database add code
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			java.sql.Connection con = DriverManager.getConnection(
//					  "jdbc:mysql://aws.connect.psdb.cloud/ems?sslMode=VERIFY_IDENTITY",
//					  "5fcctylhdxvvpq1rq8of",
//					  "pscale_pw_r3EiQxHiykDiKanr8wrXWszeSNYiolllrJWuJ15c9qG");
//			java.sql.PreparedStatement pst = con.prepareStatement("insert into login (username, password) values(?,?);");
//			pst.setString(1, request.getParameter("username"));
//			pst.setString(2, request.getParameter("password"));
//			int row = pst.executeUpdate();
//			if (row > 0) {
//				PrintWriter out = response.getWriter();
//				out.print("working....    ");
//			}else {
//				System.out.println("heldfkjsd");
//			}
//			
//		}catch(Exception e){
//			PrintWriter out = response.getWriter();
//			out.print("not working....    ");
//			e.printStackTrace();
//			System.out.println(e);
//			
//		}
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(
					  "jdbc:mysql://aws.connect.psdb.cloud/ems?sslMode=VERIFY_IDENTITY",
					  "5fcctylhdxvvpq1rq8of",
					  "pscale_pw_r3EiQxHiykDiKanr8wrXWszeSNYiolllrJWuJ15c9qG");
			java.sql.PreparedStatement pst = con.prepareStatement("SELECT * FROM ems.user_details where username = ? and password =?;");
			pst.setString(1, request.getParameter("username"));
			pst.setString(2, request.getParameter("password"));
			ResultSet row = pst.executeQuery();
			if (row.next()) {
//				PrintWriter out = response.getWriter();
//				out.print("working....    ");
				
				
				// this is create the another jsp file and send data to this file
				String username = row.getString("username");
			    String password = row.getString("password");
			    String name = row.getString("Name");
			    String email = row.getString("email");
			    int phone = row.getInt("phone");
				
				RequestDispatcher dip = request.getRequestDispatcher("registration.jsp");
				request.setAttribute("username", username);
				request.setAttribute("password", password);	
				request.setAttribute("name", name);
				request.setAttribute("email", email);	
				request.setAttribute("phone", phone);	
				dip.forward(request, response);

			}else {
				System.out.println(Integer.parseInt(request.getParameter("password")));
				
			}
			
		}catch(Exception e){
			PrintWriter out = response.getWriter();
			out.print("not working....    ");
			e.printStackTrace();
			System.out.println(e);
			
		}
	}

}
