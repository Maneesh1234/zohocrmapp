<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@include file= "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>All Leads</h2>
        <table>
        <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Billing</th>
        </tr>
              <c:forEach items="${contact}" var="contact">
              <tr>
              <td>${contact.firstName }</td>
              <td>${contact.lastName }</td>
              <td>${contact.email }</td>
              <td>${contact.mobile }</td>
              <td><a href="generateBill?id=${contact.id }">billing</a>
              </tr>
              </c:forEach>
        </table>
       
</body>
</html>