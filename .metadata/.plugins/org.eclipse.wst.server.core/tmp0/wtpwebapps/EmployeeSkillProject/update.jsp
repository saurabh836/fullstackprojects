<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/employee_records" user = "root"  password = "123456789"/>
<sql:query dataSource = "${snapshot}" sql = "select * from empskillset where empid=?" var = "result">
 
            <sql:param value="${param.empid}" />
        </sql:query>
        <form action="updatedb.jsp" method="post">
            <table border="0" width="40%">
                <caption>Update Employee</caption>
              
               <td>empname</td>
               <td>emailid</td>
               <td>password</td>
               <td>phoneno</td>
               <td>role</td>
               <td>status</td>
               </tr>
               
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                       
                        <td><input type="hidden" value="${param.empid}" name="empid"/>
                        <input type="text" value="${row.empname}" name="empname"/></td>
                        <td><input type="text" value="${row.emailid}" name="emailid"/></td>
                        <td><input type="text" value="${row.password}" name="password"/></td>
                        <td><input type="text" value="${row.phoneno}" name="phoneno"/></td>
                        <td><input type="text" value="${row.role}" name="role"/></td>
                        <td><input type="text" value="${row.active}" name="active"/></td>
                        <td><input type="submit" value="Update"/></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="hr.jsp">Go back</a>
        </form>
    </body>
</html>