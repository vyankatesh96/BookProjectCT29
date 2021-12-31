<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.List, com.book.pojo.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
<%
List<Customer> list = (List<Customer>)session.getAttribute("list");

%>
 
<table align="center" border="2" cellspacing="5" cellpadding="5">
<tr>
<td>Customer Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>Address</td>
<td>Email</td>
<td>Contact No</td>
<th colspan="2">Action</th>
</tr>

<%for(Customer c:list){ %>
<tr>
<td><%= c.getCid() %></td>
<td><%= c.getFname() %></td>
<td><%= c.getLname() %></td>
<td><%= c.getCaddress() %></td>
<td><%= c.getCemail() %></td>
<td><%= c.getContact() %></td>
<td><a href="CustomerServlet?cid=<%= c.getCid() %>&process=updateCust">Update</a></td>
<td><a href="CustomerServlet?cid=<%= c.getCid() %>&process=deleteCust" onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
</tr>

<%} %>





</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>