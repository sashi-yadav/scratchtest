<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to scratch pad</title>
</head>
<body>
<div>
	<a href="insert.jsp">Add note</a><br>
</div>
<div>
	<jsp:useBean id="sp" scope="page" class="com.scratchtest.Bean.ScratchPadBean">
	</jsp:useBean>
	<table>
		<tr>
			<th>TITLE</th>
			<th>DESCRIPTION</th>
			<th>USERID</th>
		</tr>
	  <c:forEach var="li" items="${sp.scratchPad}" >
	  	<tr>
	  	<td>${li.title} </td>
	  	<td>${li.description}</td>
	  	<td>${li.userId}</td>
	  	</tr>
	  </c:forEach>
	  </table>
</div>
</body>
</html>