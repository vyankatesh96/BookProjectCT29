<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String msg=(String)request.getAttribute("msg");
String emsg = (String)request.getAttribute("emsg");
%>

<%if(msg!=null) {%>
<h3 style="color: black;"><%=msg %></h3>
<%} %>

<%if(emsg!=null) {%>
<h3 style="color: red;"><%=emsg %></h3>
<%} %>
</body>
</html>