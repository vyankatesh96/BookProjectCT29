<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "com.book.pojo.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

function validate(element){
	
	if(element.value=="" && element.name=="fname"){
		
		element.nextSibling.innerHTML="Please Enter your First Name"
		return false;
	}
	
	else if(element.value=="" && element.name=="lname"){
		
		element.nextSibling.innerHTML="Please Enter your Last Name"
		return false;
	}
	
	else if(element.value=="" && element.name=="caddress"){
	
	element.nextSibling.innerHTML="Please Enter your Address"
	return false;
	}

	else if(element.value=="" && element.name=="cemail"){
	
	element.nextSibling.innerHTML="Please Enter your Email Id"
	return false;
	}

	else if(element.value=="" && element.name=="contact"){
	
	element.nextSibling.innerHTML="Please Enter your Contact"
	return false;
	}

	if(element.value=="" && element.name=="password"){
	
	element.nextSibling.innerHTML="Please Enter your Password"
	return false;
	}
	
	
	else{
		
		element.nextSibling.innerHTML="*";
	}
}




</script>
</head>
<body>
<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<form action="CustomerServlet" method="post" >

<input type="hidden" name="process" value="updateCust">


<table align="center" border="2">
<tr>
     <th>Customer Id : </th>
     	<td>
     	
            <input type="text" class="validateMe" value="${uCust.cid }" onblur="validate(this)" name="cid" readonly><span style="color: red">*</span>
  </td>
</tr>

<tr>
     <th>First Name : </th>
     	<td>
     	
            <input type="text" class="validateMe" value="${uCust.fname }" onblur="validate(this)" name="fname"><span style="color: red">*</span>
  </td>
</tr>

<tr>
		<th>Last Name : </th>
			<td>
			
			 <input type="text" class="validateMe" value="${uCust.lname }" onblur="validate(this)" name="lname"><span style="color: red">*</span>
			
		</td>
</tr>

<tr>
        <th>Address : </th>
             <td>
                  <input type="text" class="validateMe" value="${uCust.caddress }" onblur="validate(this)" name="caddress"><span style="color: red">*</span>
                  
             </td>
</tr>

<tr>
<th>Email Id : </th><td><input type="text" class="validateMe" value="${uCust.cemail }" onblur="validate(this)" name="cemail"><span style="color: red">*</span></td>
</tr>

<tr>
<th>Contact No.: </th><td><input type="text" class="validateMe" value="${uCust.contact }" onblur="validate(this)" name="contact"><span style="color: red">*</span></td>
</tr>

<tr>
<th>Password : </th><td><input type="password" class="validateMe" value="${uCust.password }" onblur="validate(this)" name="password" readonly><span style="color: red">*</span></td>
</tr>

<tr>
<td align="left"><input type="submit" value="Update Customer"></td>

</tr>

</table>

</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>