 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServelt" method="post">

<input type="hidden" name="process" value="login"> 

<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<table  align="center" >
<tr>
 <th>Type: </th>
      <td> 
         <select name="utype">
  
       <option value="Admin">Admin</option>
       <option value="Customer">Customer</option>
      
      </select>
      </td>
</tr>


<tr>
 <th>Email: </th>
      <td> <input type="text" name="uEmail"> </td>
</tr>

<tr>
 <th>Password: </th>
      <td> <input type="password" name="uPassword"> </td>
</tr>

<tr>
<td align="center"><input type="Reset" value="Reset"></td>
<td align="left"><input type="submit" value="Login"></td>

</tr>

<tr>
<td align="center" colspan="2"><a href="">Forgot Password ?</a></td>
</tr>

</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>