<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserServlet" method="post">
Add new record:
<br/><br/>
Enter employee id :<input type="text" name="empid"  placeholder="enter id" /><br/>  
Enter name :<input type="text" name="empname"  placeholder="enter name" /><br/>  
Enter email id :<input type="text" name="emailid"  placeholder="enter email" /><br/>
Enter password :<input type="password" name="password"  placeholder="enter password" /><br/>  
Enter phone number: <input type="text" name="phoneno"  placeholder="phone no" /><br/>
Enter role : <input type="radio" name="role" value="manager" />Manager&nbsp;&nbsp; <input type="radio" name="role" value="employee" />employee&nbsp;&nbsp;<br/>
<input type="submit" value="Register" />

</form>
</body>
</html>