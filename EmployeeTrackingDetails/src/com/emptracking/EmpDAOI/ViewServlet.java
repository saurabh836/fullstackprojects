package com.emptracking.EmpDAOI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emptracking.empDAO.Employee;

import java.io.PrintWriter;  
import java.util.List; 

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		{
			 response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		        out.println("<a href='Index.html'>Add New Employee</a>");  
		        out.println("<h1>Employees List</h1>");  
		          
		        List<Employee> list=EmpDAOI.getAllEmployees();  
		          
		        out.print("<table border='1' width='100%'");  
		        out.print("<tr><th>EmployeeId</th><th>Name</th><th>Designation</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>");  
		        for(Employee e:list){  
		         out.print("<tr><td>"+e.getEid()+"</td><td>"+e.getEname()+"</td><td>"+e.getEdesignation()+"</td><td>"+e.getEsalary()+"</td><td><a href='EditServlet?eid="+e.getEid()+"'>edit</a></td>  <td><a href='DeleteServlet?eid="+e.getEid()+"'>delete</a></td></tr>");  
		        }  
		        out.print("</table>");  
		          
		        out.close();  
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
