package com.emp.projectDAO;

public class Employee {
	int empid;
	String empname;
	String emailid;
	String password;
	String phoneno;
	String role;
	boolean active;
	boolean valid;
	public int getempid() {
		return empid;
	}
	public void setempid(int empid) {
		this.empid = empid;
	}
	public String getempname() {
		return empname;
	}
	public void setempname(String empname) {
		this.empname = empname;
	}
	public String getemailid() {
		return emailid;
	}
	public void setemailid(String emailid) {
		this.emailid = emailid;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getphoneno() {
		return phoneno;
	}
	public void setphoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role = role;
	}
	public boolean isactive() {
		return active;
	}
	public void setactive(boolean active) {
		this.active = active;
	}
	  public boolean isValid() {
	         return valid;
		}

	      public void setValid(boolean newValid) {
	         valid = newValid;
		}	

}