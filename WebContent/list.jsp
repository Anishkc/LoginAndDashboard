<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.test.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval() %> url=login.jsp">
<title>Insert title here</title>
</head>
<body>
     <h1>User list</h1>
     <hr>
     <table align="center" width="100%" cellpadding="1px;" bgcolor="red">
     
     <tr bgcolor="yellow">
     	<td>first name</td>
        <td>last name</td>
        <td>Username</td>
        <td>Password</td>
      </tr>  
        <%
         List<User> ulist =(List<User>) request.getAttribute("ulist");
         
        
        for(User u : ulist){
         %> 
         <tr bgcolor="skyblue">
		     	<td><%=u.getFname() %></td>
		        <td><%=u.getLname() %></td>
		        <td><%=u.getUsername() %></td>
		        <td><%=u.getPassword() %></td>
         </tr>
         <% 
         }         
        %>
     
     </table>
</body>
</html>