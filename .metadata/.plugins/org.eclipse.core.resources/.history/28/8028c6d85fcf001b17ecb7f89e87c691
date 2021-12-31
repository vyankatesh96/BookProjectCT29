<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List, com.book.pojo.Book"%>
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
List<Book> list = (List<Book>)session.getAttribute("list");
%>


<table border="2" align ="center">
<tr>
<td>Id</td>
<td>Name</td>
<td>Author</td>
<td>Price</td>
<td>Publisher</td>
<td>No. of Copies</td>
<td>Description</td>	
<td>Rating</td>
<td>Category</td>
<td>Image</td>
<th colspan="2">Action</th>
</tr>

<%for(Book b: list) {%>
<tr>
<td><%= b.getBookid() %></td>
<td><%= b.getBookname() %></td>
<td><%= b.getAuthor() %></td>
<td><%= b.getBookprice() %></td>
<td><%= b.getPublisher() %></td>
<td><%= b.getNoOfCopies() %></td>
<td><%= b.getDescription() %></td>
<td><%= b.getRating() %></td>
<td><%= b.getCategory() %></td>
<td><img alt="" src="ImageServlet?bookid=<%=b.getBookid() %>"height="100" width="70"></td>
<td><a href="BookServlet?bookid=<%=b.getBookid() %>&process=updateBook">Update</a></td>
<td><a href="BookServlet?bookid=<%=b.getBookid() %>&process=deleteBook" onclick="return confirm('Are you sure you want to delete ? ')">Delete</a></td>
</tr>
<%} %>

</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>