<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
<table align="center" border="2">

<tr>
   <th>Id </th>
      <td>
       ${Vbook.bookid }
   </td>
</tr>


<tr>
   <th>Name </th>
      <td>
       ${Vbook.bookname }
   </td>
</tr>


<tr>
   <th>Author </th>
      <td>
       ${Vbook.author }
   </td>
</tr>


<tr>
   <th>Price </th>
      <td>
       ${Vbook.bookprice }
   </td>
</tr>


<tr>
   <th>Publisher </th>
      <td>
       ${Vbook.publisher }
   </td>
</tr>


<tr>
   <th>No. of Copies </th>
      <td>
       ${Vbook.noOfCopies }
   </td>
</tr>


<tr>
   <th>Description </th>
      <td>
       ${Vbook.description }
   </td>
</tr>


<tr>
   <th>Rating </th>
      <td>
       ${Vbook.rating }
   </td>
</tr>


<tr>
   <th>Category </th>
      <td>
       ${Vbook.category }
   </td>
</tr>


<tr>
   <th>Image </th>
      <td>
       <img alt="" src="ImageServlet?bookid=${Vbook.bookid }"height="100" width="70">
   </td>
</tr>
</table>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>