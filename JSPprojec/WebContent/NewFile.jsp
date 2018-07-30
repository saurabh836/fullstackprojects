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

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/employeedetails" user = "root"  password = "123456789"/>
<sql:query dataSource = "${snapshot}" sql = "select * from emp_data" var = "result" />
<table border="1">
<tr><td>empid</td><td>empname</td><td>empdesig</td><td>empsalary</td></tr>
<c:forEach items="${result.rows }" var ="res">
<tr>
<td>${res.eid}</td>
<td>${res.ename}</td>
<td>${res.edesignation}</td>
<td>${res.esalary}</td>
</tr>
</c:forEach>
</table>
</body>
</html>