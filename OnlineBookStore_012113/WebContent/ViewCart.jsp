<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.book.pojo.Cart"%>

<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Public's Online Book Store</title>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
$(function(){

	$(".qty").click(function(){
		
		var q = this.value;
		
		var id = this.nextSibling.value;
		
		$.post("CartServlet",
				{
			"Quantity":q,
			"Cid":id,
			"process":"updateQuantity"
				}
		);
		
	});
	
})

function billing(){
	
	var q= $(".qty");
	var p= $(".price");
	var total=0;
	
	for(i=0; i<q.length; i++){
		
		total+=(q[i].value*p[i].value);
	}
	
	$("#bill").val(total);
}

$(function(){
	
	$(".qty").click(function(){
		
		var q= $(".qty");
		
		for(var i=0; i<q.length; i++){
			
			if(q[i].value<1){
				
				q[i].value=1;
				
				var id = q[i].nextSibling.value;
				
				$.post("CartServlet",
						{
					"Quantity":q,
					"Cid":id,
					"process":"updateQuantity"
						}
				);
			}
			else{
				
				billing();
			}
		}
	})
	billing();
});


</script>
</head>
<body>
<%-- <%List<Cart> list = (List<Cart>)session.getAttribute("MyClist"); %> --%>
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
<th>Action</th>
</tr>

<c:forEach  var="cart" items="${MyClist }">
<tr>
<td><input type="text" name="cartid" value="${cart.cartid }" readonly></td>
<td><input type="text" name="bookname" value="${cart.bookname }" readonly></td>
<td><input type="number" name="quantity" value="${cart.quantity }" class="qty" ><input type="hidden" value="${cart.cartid }"></td>
<td><input type="text" name="bookprice" class="price" value="${cart.bookprice }" readonly></td>
<td><a href="CartServlet?cartid=${cart.cartid }&process=deleteCart">Delete</a></td>
</tr>

</c:forEach>

<tr><td colspan="3" style="text-align: right">Total bill: </td><td colspan="2"><input id="bill" name="bill"></td></tr>

<tr><td colspan="5" align="center"><input type="submit" value="Place Order"></td></tr>

</table>

<jsp:include page="footer.jsp"></jsp:include>
</form>
</body>
</html>