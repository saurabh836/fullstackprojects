package com.emptracking.EmpDAOI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emptracking.empDAO.Employee;

import java.io.PrintWriter; 

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath())
		{
			
			response.setContentType("text/html");  
			PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Employee</h1>");  
	        int eid=Integer.parseInt(request.getParameter("eid"));  
	        Employee e=EmpDAOI.getEmployeeById(eid);  
	          
	        out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='eid' value='"+e.getEid()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='ename' value='"+e.getEname()+"'/></td></tr>");   
	        out.print("<tr><td>Designation:</td><td>");  
	        out.print("<select name='edesignation' style='width:150px'>");  
	        out.print("<option>Sr.Tester</option>");  
	        out.print("<option>Jr.Tester</option>");  
	        out.print("<option>SoftEng</option>");  
	        out.print("<option>Sr.Soft Developer</option>");  
	        out.print("</select>");  
	        out.print("</td></tr>"); 
	        out.print("<tr><td>Salary:</td><td><input type='text' name='esalary' value='"+e.getEsalary()+"'/></td></tr>");
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		{
		
			
		}
	}

}
