<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	if(element.value=="" && element.name=="currentpassword"){
	
	element.nextSibling.innerHTML="Please Enter your Password"
	return false;
	}
	
	
	else{
		
		element.nextSibling.innerHTML="*";
	}
}

function validateWithClass(){
	
	var arr= document.getElementsByClassName("validateMe");
	var flag=true;
	
	for(var i=0; i<arr.length; i++){
		
		var element=arr[i];
	
	flag= validate(element);
	
	if(flag==false){
		
		break;
	}
}
return flag;
}



</script>

</head>
<body>
<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<form action="CustomerServlet" method="post" >
<input type="hidden" name="process" value="addcustomer">


<table align="center" border="2">
<tr>
     <th>First Name : </th>
     	<td>
            <input type="text" class="validateMe" onblur="validate(this)" name="fname"><span style="color: red">*</span>
      </td>
</tr>


<tr>
		<th>Last Name : </th>
			<td>
			 <input type="text" class="validateMe" onblur="validate(this)" name="lname"><span style="color: red">*</span>
		</td>
</tr>


<tr>
      <th>Address : </th>
          <td>
             <input type="text" class="validateMe" onblur="validate(this)" name="caddress"><span style="color: red">*</span>
     </td>
</tr>


<tr>
     <th>Email Id : </th>
        <td>
            <input type="text" class="validateMe" onblur="validate(this)" name="cemail"><span style="color: red">*</span>
     </td>
</tr>

<tr>
	<th>Contact No.: </th>
		<td>
			<input type="text" class="validateMe" onblur="validate(this)" name="contact"><span style="color: red">*</span>
	</td>
</tr>

<tr>
	 <th>Password : </th>
	 	<td>
	 	    <input type="password" class="validateMe" onblur="validate(this)" name="password"><span style="color: red">*</span>
	 </td>
</tr>

<tr>
<td align="left">
   <input type="submit" onclick=" return validateWithClass()" value="Add Customer">
    </td>
<td align="left">
    <input type="submit" value="Reset">
    </td>
</tr>

</table>

</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>