

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Welcome </h1>         
Display All Details
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/employee_records" user = "root"  password = "123456789"/>
<sql:query dataSource = "${snapshot}" sql = "select * from empskillset" var = "result" />
<table border="1">
<tr><td>empid</td><td>empname</td><td>emailid</td><td>password</td><td>phoneno</td><td>role</td><td>status</td></tr>
<c:forEach items="${result.rows }" var ="res">
<tr>
<td>${res.empid}</td>
<td>${res.empname}</td>
<td>${res.emailid}</td>
<td>${res.password}</td>
<td>${res.phoneno}</td>
<td>${res.role}</td>
<td>${res.active}</td>
<td><a href="update.jsp?empid=<c:out value="${res.empid}"/>">Update</a></td>
<td><a href="deletedb.jsp?empid=<c:out value="${res.empid}"/>">Delete</a></td>
               


</tr>
</c:forEach>
 <a href="index.jsp">Go back</a>
</body>
</html>