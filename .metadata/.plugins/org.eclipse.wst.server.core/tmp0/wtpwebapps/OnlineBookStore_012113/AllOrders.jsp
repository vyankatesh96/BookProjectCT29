<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List, com.book.pojo.Order"%>
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
List<Order>Olist=(List<Order>) session.getAttribute("AllOrders"); 
%>


<%
if(!(Olist.isEmpty())){
%>
<table align="center" border="2">
<tr>
<th>OrderId</th>
<th>Status</th>
<th>Date</th>
<th>Email</th>
<th>Total Bill</th>
<th colspan="2">Action</th>
</tr>

<%for(Order o: Olist) {%>
<tr>
<td><%= o.getOrderId() %></td>
<td><%= o.getOrderStatus() %></td>
<td><%= o.getOrderDate() %></td>
<td><%= o.getCemail() %></td>
<td><%= o.getTotalBill() %></td>
<td><a href="OrderServlet?process=updateStatus&orderId=<%= o.getOrderId() %>">Update Status</a></td>
<td><a href="OrderServlet?process=CancelOrder&orderId=<%= o.getOrderId() %>">Cancel Order</a></td>
</tr>
<%} %>
</table>

<%}
else{
	
	out.print("No data to display");
}
%>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>