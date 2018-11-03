<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Data</title>
</head>
<body>
<div>
	<form action="${pageContext.request.contextPath}/addScratch" method="post">
		<div>
		<label>Title:</label>
		<input type="text" name="title" placeholder="Enter title" required>
		</div>
		<label>Description:</label><br>
		<textarea rows="10" cols="50" name="description" required></textarea> 
		<div>
		<label>UserID:</label>
		<input type="text" name="userid" placeholder="Enter UserID" required>
		</div>
		<input type="submit">
	</form>
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