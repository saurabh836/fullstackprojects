<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/employee_records" user = "root"  password = "123456789"/>

 
        <sql:update dataSource="${snapshot}" var="count">
            UPDATE empskillset SET empname=?,emailid=?,password=?,phoneno=?,role=?,active=?
            WHERE empid='${param.empid}'
            <sql:param value="${param.empname}" />
            <sql:param value="${param.emailid}" />
            <sql:param value="${param.password}" />
             <sql:param value="${param.phoneno}" />
              <sql:param value="${param.role}" />
              <sql:param value="${param.active}" />
        </sql:update>
        <c:if test="${count>=1}">
            <font size="5" color='green'> Congratulations ! Data updated
            successfully.</font>
              <a href="hr.jsp">Go back</a>          
        </c:if>

</body>
</html>