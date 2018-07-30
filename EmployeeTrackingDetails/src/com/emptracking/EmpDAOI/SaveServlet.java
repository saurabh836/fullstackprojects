package com.emptracking.EmpDAOI;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emptracking.empDAO.Employee;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		{
			 response.setContentType("text/html");  
			 PrintWriter out=response.getWriter();  
			 int eid=Integer.parseInt(request.getParameter("eid"));  
		     String ename=request.getParameter("ename");  
		     String edesignation=request.getParameter("edesignation");  
		     float esalary=Float.parseFloat(request.getParameter("esalary"));  
		     
		     
		     Employee e=new Employee();  
		        e.setEid(eid);
		        e.setEname(ename);
		       e.setEdesignation(edesignation);
		       e.setEsalary(esalary);
		          
		        int status=EmpDAOI.save(e);  
		        if(status>0){  
		            out.print("<p>Record saved successfully!</p>");  
		            request.getRequestDispatcher("Index.html").include(request, response);  
		        }else{  
		            out.println("Sorry! unable to save record");  
		        }  
		          
		        out.close();  
		    }  
	}
}