package com.emp.projectcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emp.projectDAO.Employee;

import com.emp.projectDAO.EmpDaoi;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Employee emp = new Employee();
		emp.setempid(Integer.parseInt(request.getParameter("empid"))); 
		emp.setempname(request.getParameter("empname"));
		emp.setemailid(request.getParameter("emailid"));
		emp.setpassword(request.getParameter("password"));
		emp.setphoneno(request.getParameter("phoneno"));
		emp.setrole(request.getParameter("role"));
		emp.setactive(false);
		
		EmpDaoi ed = new EmpDaoi();
		int i = ed.insert(emp);
		
		if (i>0)
		{
			PrintWriter out=response.getWriter();
			out.println("<p>record inserted succesfully!</p>");
			 out.println("<a href='index.jsp'>Go to login</a>");
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("Failed!!");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
