package com.niit.skillmap.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.skillmap.config.DBConfig;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Connection connection=null;
	static ResultSet rs = null;  
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	
    public AdminServlet() {
    	connection=DBConfig.getConnection();
    	
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
	    //String msg = " ";
		
	    String username = request.getParameter("emailid");
	    String password = request.getParameter("password");
	    	/*HttpSession session = request.getSession();
	         username = (String)request.getAttribute("username");
	    session.setAttribute("username", username);;*/
	    
	    try {
	       // Class.forName("com.mysql.jdbc.Driver");

	        //Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");  

	        String strQuery = "select * from empskillset WHERE emailid='"
	                + username + "' and password='" + password + "'";
	        Statement st = connection.createStatement();
	        ResultSet rs = st.executeQuery(strQuery);
	        int x=0;
	 
	       /* if (rs.next()) {
	        	
	        	
	        	
	           // msg = "HELLO" + username + "! Your login is SUCESSFULL";
	        	//request.setAttribute("name", "username");
	        	request.getRequestDispatcher("hr.jsp").forward(request,response);
	        	

	        } else {
	            //msg = "HELLO" + username + "!Your login is UNSUCESSFULL";
	        	request.getRequestDispatcher("error.jsp").forward(request,response);
	        }*/
	        while(rs.next())
	        {
	        	if(rs.getString("emailid").equals(username)&&rs.getString("password").equals(password))
	        	{
	        		String stp=rs.getString("role");
	        		if(stp.equals("hr"))
	        		{
	        			x=1;
	        			break;
	        			
	        		}
	        		else if(stp.equals("manager"))
	        		{
	        			x=2;
	        			break;
	        		}
	        		}
	        	}
	       
	        
	         if(x==1)
	         {
	        	 response.sendRedirect("hr.jsp");
	         }
	         else if(x==2)
	         {
	        	 
	        	 response.sendRedirect("manager.jsp");
	         }
	         else
	         {
	        	 response.sendRedirect("error.jsp");
	         }
	         
	       
	        rs.close();
	        st.close();
	        //System.out.println("test :" + msg);
	        //PrintWriter out = response.getWriter();
	    } 
	    
	    catch (Exception e) {
	    
	    
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