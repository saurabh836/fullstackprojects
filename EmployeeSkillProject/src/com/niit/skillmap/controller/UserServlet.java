package com.niit.skillmap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillmap.config.DBConfig;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static Connection connection=null;
	static ResultSet rs = null; 
    public UserServlet() {
        //super();
    	connection=DBConfig.getConnection();
    	 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
        int empid=Integer.parseInt(request.getParameter("empid"));
		String empname=request.getParameter("empname"); 
		String emailid=request.getParameter("emailid"); 
		String password=request.getParameter("password"); 
		String phoneno=request.getParameter("phoneno"); 
		String role=request.getParameter("role");
	    
		try{ 
		//Class.forName("com.mysql.jdbc.Driver"); 
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");

		PreparedStatement ps=connection.prepareStatement("insert into empskillset values(?,?,?,?,?,?,?)");

		ps.setInt(1,empid);
		ps.setString(2,empname); 
		ps.setString(3,emailid); 
		ps.setString(4,password); 
		ps.setString(5,phoneno);
		ps.setString(6, role);
		ps.setBoolean(7,false);
		int i=ps.executeUpdate(); 
		if(i>0) 
		out.print("<p>Record inserted succesffully...</p>");

		 
		}catch (Exception e2) {System.out.println(e2);}

		out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
