<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<form action="OrderServlet" method="post">
<input type="hidden" name="process" value="order">

<table align="center">
<tr>
<th>Cart Id</th>
<th>Book Name</th>
<th>Quantity</th>
<th>Book Price</th>
<th>Email Id</th>
<th>Action</th>
</tr>

<c:forEach  var="cart" items="${allcartCopy }">
<tr>
<td><input type="text" name="cartid" value="${cart.cartid }" readonly></td>
<td><input type="text" name="bookname" value="${cart.bookname }" readonly></td>
<td><input type="number" name="quantity" value="${cart.quantity }" readonly></td>
<td><input type="text" name="bookprice"  value="${cart.bookprice }" readonly></td>
<td><input type="text" value="${cart.cemail }" name="cemail" readonly></td>
<td><a href="BookServlet?process=updateCopies&cartid=${cart.cartid }">Packed</a></td>
</tr>

</c:forEach>


</table>

</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>