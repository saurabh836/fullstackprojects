package com.emp.projectcontroller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.projectDAO.EmpDaoi;
import com.emp.projectDAO.Employee;
import com.niit.skillmap.config.DBConfig;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*Employee e=new Employee();
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("emailid");
		String password = request.getParameter("password");
		
		try(PrintWriter out=response.getWriter()) {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_records","root","123456789");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from empskillset where emailid='"+username+"' and password='"+password+"'");
			//out.println(username);
			//out.println(password);
		
			if(username=rs.em && password==pass)
			{
				//out.println("login success");
	            request.getRequestDispatcher("/WEB-INF/Hr.jsp").forward(request, response);  
			}
			
		}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				
			}*/
		try {
		
		Employee emp=new Employee();
		emp.setemailid(request.getParameter("username"));
		emp.setpassword(request.getParameter("password"));
		emp=EmpDaoi.login(emp);
		if(emp.isValid())
		{
			request.setAttribute("username", emp);
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
		
		}
		catch(Exception e)
		{
			
			
		}
		//request.setAttribute(arg0, arg1);
		
		
	//if(e.)
		//if(username.equals(e.getemailid()&&password.equals(e.getpassword()))
		
		//request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
			
			//request.getRequestDispatcher("error.jsp").forward(request, response);
			
			
		
		
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
