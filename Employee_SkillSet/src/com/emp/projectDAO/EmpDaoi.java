package com.emp.projectDAO;

import java.io.PrintWriter;
import java.sql.*;

import com.niit.skillmap.config.DBConfig;

//import com.niit.project.model.Employee;

public class EmpDaoi {
	
	static Connection connection=null;
	static ResultSet rs = null;  
	
	public EmpDaoi() {
		connection=DBConfig.getConnection();
	}
	
	
	/*public static int userlogin(Employee e)
	{
		int status=0;
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");  
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_records","root","123456789");  
			//System.out.println("Connected");
			Statement stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from empskillset where emailid='"+e.getemailid()+"' and password='"+e.getpassword()+"'");
		if(rs.next())
		{
		System.out.println("Login successful!");
		status=1;
		}
		connection.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		return status;
	}
	*/
	/*public static Employee login(Employee emp)
	{
		Statement stmt=null;
		String username = emp.getemailid();    
        String password = emp.getpassword();
        
        String searchQuery =
                "select * from empskillset where emailid='"
                         + username
                         + "' AND password='"
                         + password
                         + "'";
        System.out.println("Your user name is " + username);          
        System.out.println("Your password is " + password);
        try 
        {
           //connect to DB 
          // currentCon = ConnectionManager.getConnection();
           stmt=connection.createStatement();
           rs = stmt.executeQuery(searchQuery);            
           boolean more = rs.next();
             
           // if user does not exist set the isValid variable to false
           if (!more) 
           {
              System.out.println("Sorry, you are not a registered user! Please sign up first");
              emp.setactive(false);
           } 
              
           //if user exists set the isValid variable to true
           else if (more) 
           {
              String name = rs.getString("empname");
              //String lastName = rs.getString("LastName");
               
              System.out.println("Welcome " + name);
             emp.setempname(name);
             // bean.setLastName(lastName);
              emp.setactive(true);
           }
        } 

        catch (Exception ex) 
        {
           //System.out.println("Log In failed: An Exception has occurred! " + ex);
        } 
          
         
        
        
        return emp;
		
	}
	*/
	public static Employee login(Employee employee)
	{
		 Statement stmt = null;    
			
         String username = employee.getemailid();   
         String password = employee.getpassword();
	    
         String Query =
               "select * from empskillset where emailid='"
                        + username
                        + "' AND password='"
                        + password
                        + "'";
	    
      // "System.out.println" prints in the console; Normally used to trace the process
     
	    
      try 
      {
         //connect to DB 
         //connection = ConnectionManager.getConnection();
         stmt=connection.createStatement();
         rs = stmt.executeQuery(Query);	        
         boolean more = rs.next();
	       
         // if user does not exist set the isValid variable to false
         if (!more) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
          employee.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) 
         {
            String Name = rs.getString("empname");
            //String lastName = rs.getString("LastName");
	     	
           // System.out.println("Welcome " +Name);
            employee.setempid(rs.getInt(1));
			employee.setempname(rs.getString(2));
			employee.setemailid(rs.getString(3));
			employee.setpassword(rs.getString(4));
			employee.setphoneno(rs.getString(5));
			employee.setrole(rs.getString(6));
			employee.setactive(rs.getBoolean(7));
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
      	return employee;
	}
	
	
	public int insert(Employee e)
	{
		int status=0;
		
		try {
			 
			PreparedStatement p = connection.prepareStatement("insert into empskillset values( ?,?,?,?,?,?,?);");
			p.setInt(1,e.getempid());
			p.setString(2,e.getempname());
			p.setString(3,e.getemailid());
			p.setString(4, e.getpassword());
			p.setString(5, e.getphoneno());
			p.setString(6, e.getrole());
			//p.setString(7, "false");
			p.setBoolean(7, false);

			status = p.executeUpdate();
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return status;
	}
	
	


	/*public Employee getEmploeeByLogin(String username,String password)
	{
		try 
		{
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from empskillset where emailid='"+username+"' and password='"+password+"'");
		Employee employee=new Employee();
		while(rs.next())
		{
			employee.setempid(rs.getInt(1));
			employee.setempname(rs.getString(2));
			employee.setemailid(rs.getString(3));
			employee.setpassword(rs.getString(4));
			employee.setphoneno(rs.getString(5));
			employee.setrole(rs.getString(6));
			employee.setactive(rs.getBoolean(7));
		
					
		}
		return employee;
		}
		 catch (Exception ex) {
		//Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
			 return null;
		}
		
		
	}*/
}
