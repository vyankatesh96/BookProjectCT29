<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

function validate(element){
	
	if(element.value=="" && element.name=="bookname"){
		
		element.nextSibling.innerHTML="Please enter Book name"
		return false;
	}
	
	else if(element.value=="" && element.name=="author"){
	
		element.nextSibling.innerHTML="Please enter author name"
		return false;
	}
	
	else if(element.value=="" && element.name=="bookprice"){
		
		element.nextSibling.innerHTML="Please enter Book Price"
		return false;
	}
	
	else if(element.value=="" && element.name=="publisher"){
		
		element.nextSibling.innerHTML="Please enter publisher name"
		return false;
	}
	
	else if(element.value=="" && element.name=="noOfCopies"){
		
		element.nextSibling.innerHTML="Please enter No. Of Copies"
		return false;
	}
	
	else if(element.value=="" && element.name=="image"){
		
		element.nextSibling.innerHTML="Please upload image"
		return false;
	}
	
	else if(element.value=="" && element.name=="description"){
		
		element.nextSibling.innerHTML="Please enter Book description"
		return false;
	}
	
	else if(element.value=="" && element.name=="rating"){
		
		element.nextSibling.innerHTML="Please enter Book rating"
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
<!-- <marquee>Welcome to Our Website</marquee> -->

<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<form action="BookServlet" method="post" enctype="multipart/form-data">

<input type="hidden" name="process" value="addbook">

<table align="center" border="2">
<tr>
<th>Name: </th><td><input type="text" class="validateMe" onblur="validate(this)" name="bookname"><span style="color:red">*</span></td>
</tr>

<tr>
<th>Author : </th><td><input type="text" class="validateMe" onblur="validate(this)" name="author"><span style="color:red">*</span></td>
</tr>

<tr>
<th>Price : </th><td><input type="text" class="validateMe" onblur="validate(this)" name="bookprice"><span style="color:red">*</span></td>
</tr>

<tr>
<th>Publisher : </th><td><input type="text" class="validateMe" onblur="validate(this)" name="publisher"><span style="color:red">*</span></td>
</tr>

<tr>
<th>No. of Copies : </th><td><input type="text" class="validateMe" onblur="validate(this)" name="noOfCopies"><span style="color:red">*</span></td>
</tr>

<tr>
<th>Description : </th><td><input type="text" class="validateMe" onblur="validate(this)" name="description"><span style="color:red">*</span></td>
</tr>

<tr>
<th>Rating : </th><td><input type="text" class="validateMe" onblur="validate(this)" name="rating"><span style="color:red">*</span></td>
</tr>

<tr>
<th>Category :</th>
<td><select name="category">
<option value="Fiction">Fiction</option>
<option value="Non-Fiction">Non-Fiction</option>
<option value="Religious">Religious</option>
<option value="Self-Help">Self-Help</option>
<option value="Science">Science</option>
<option value="Auto-Biography">Auto-Biography</option>
</select></td>
</tr>

<tr>
<th>Image :</th><td><input type="file" class="validateMe" onblur="validate(this)" name="image"><span style="color:red">*</span></td>
</tr>

<tr>

<td align="center"><input type="submit" onclick=" return validateWithClass()" value="AddBook"></td>
<td><input type="reset" value="Reset"></td>
</tr>
</table>
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>