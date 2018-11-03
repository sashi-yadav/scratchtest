<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.scratchtest.model.ScratchPad" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th,td{
	padding: 15px;
}
</style>
</head>
<body>
<table>
<tr>
	<th>TITLE</th>
	<th>DESCRIPTION</th>
	<th>USERID</th>
</tr>
<%
  ArrayList<ScratchPad> sps=(ArrayList<ScratchPad>)request.getAttribute("list"); 
  for (ScratchPad sp: sps) {   
%>
  <tr>
    <td><%=sp.getTitle()%></td>
    <td><%=sp.getDescription() %></td>
    <td><%=sp.getUserId() %></td>
   </tr>
<%}%>
</table>
</body>
</html>