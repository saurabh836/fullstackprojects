package com.emptracking.EmpDAOI;
import com.emptracking.*;
import com.emptracking.empDAO.Employee;

import java.util.*;
import java.sql.*;

public class EmpDAOI {
	
	public static Connection getConnection()
	{
		Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetails","root","123456789");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Employee e){  
        int status=0;  
        try{  
            Connection con=EmpDAOI.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into emp_data(eid,ename,edesignation,esalary) values (?,?,?,?)");  
            ps.setInt(1,e.getEid());  
            
            ps.setString(2,e.getEname());  
            ps.setString(3,e.getEdesignation());  
            ps.setFloat(4,e.getEsalary());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Employee e){  
        int status=0;  
        try{  
            Connection con=EmpDAOI.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update emp_data set ename=?,edesignation=?,esalary=? where eid=?");  
          
            ps.setString(1,e.getEname());  
            ps.setString(2,e.getEdesignation());  
            ps.setFloat(3,e.getEsalary());  
            ps.setInt(4,e.getEid());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int eid){  
        int status=0;  
        try{  
            Connection con=EmpDAOI.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from emp_data where eid=?");  
            ps.setInt(1,eid);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Employee getEmployeeById(int eid){  
        Employee e=new Employee();  
          
        try{  
            Connection con=EmpDAOI.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp_data where eid=?");  
            ps.setInt(1,eid);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setEid(rs.getInt(1));  
                e.setEname(rs.getString(2));  
                e.setEdesignation(rs.getString(3));  
                e.setEsalary(rs.getFloat(4));  
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Employee> getAllEmployees(){  
        List<Employee> list=new ArrayList<Employee>();  
          
        try{  
            Connection con=EmpDAOI.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp_data");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Employee e=new Employee();  
                e.setEid(rs.getInt(1));  
                e.setEname(rs.getString(2));  
                e.setEdesignation(rs.getString(3));  
                e.setEsalary(rs.getFloat(4));  
              
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
        return list;
          
    }
}