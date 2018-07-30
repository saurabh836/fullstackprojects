package com.niit.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
public class EmpDao {


	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
	}
	
	
	public int save(Emp p)
	{
		String sql="insert into emp_data(ename,edesignation,esalary)values('"+p.getEname()+"','"+p.getEdesignation()+"',"+p.getEsalary()+")";
		return template.update(sql);
		
	}
	
	public int update(Emp p)
	{
		String sql="upate emp_date set ename='"+p.getEname()+"',edesignation='"+p.getEdesignation()+"',salary="+p.getEsalary()+"where eid="+p.getEid()+"";
		return template.update(sql);
		
		
		
	}
	
	public int delete(int eid){  
	    String sql="delete from emp_data where eid="+eid+"";  
	    return template.update(sql);  
	}  
	public Emp getEmpById(int eid){  
	    String sql="select * from emp_data where eid=?";  
	    return template.queryForObject(sql, new Object[]{eid},new BeanPropertyRowMapper<Emp>(Emp.class));  
	}  
	public List<Emp> getEmployees(){  
	    return template.query("select * from emp_data",new RowMapper<Emp>(){  
	        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
	            Emp e=new Emp();  
	            e.setEid(rs.getInt(1));  
	            e.setEname(rs.getString(2));  
	             e.setEdesignation(rs.getString(3));  
	            e.setEsalary(rs.getFloat(4));  
	            return e;  
	        }  
	    }
	    
	    		);
	}
}
	
	


