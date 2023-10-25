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
<a href="viewCreateLead">Add new list</a>
 <table>
      
        <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Source</th>
        <th>Billing</th>
        </tr>
              <c:forEach items="${leads}" var="leads">
              <tr>
              <td><a href="leadInfo?id=${leads.id}">${leads.firstName }</a></td>
              <td>${leads.lastName }<td>
              <td>${leads.email }</td>
              <td>${leads.mobile }</td>
              <td>${leads.source }</td>
             
              </tr>
              </c:forEach>
        </table>
</body>
</html>