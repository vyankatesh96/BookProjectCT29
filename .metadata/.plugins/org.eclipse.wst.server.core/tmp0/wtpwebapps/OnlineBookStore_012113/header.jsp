<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--  Free CSS Templates from www.templatemo.com -->
<%
String customer = (String)session.getAttribute("customer");
String admin = (String)session.getAttribute("admin");
%>
<div id="templatemo_container">
	<div id="templatemo_menu">
    	<ul>
    	
    	  <% if(admin==null && customer==null ){ %> 
            <li><a href="index.jsp" class="current">Home</a></li>
            <li><a href="addCustomer.jsp" class="current">Register</a></li>
            <li><a href="Login.jsp">Login</a>
           <%} %>
           
           <% if(admin!=null && customer==null ){ %> 
           <li><a href="index.jsp" class="current">Home</a></li>
            <li><a href="addBook.jsp" class="current">Add Book</a></li>
            <li><a href="CustomerServlet?process=Customerlist" class="current">Customer list</a></li>
            <li><a href="CartServlet?process=allCart" class="current">Entire Cart</a></li>
            <li><a href="BookServlet?process=AllBooks" class="current">All Books</a></li>
            <li><a href="OrderServlet?process=allOrders" class="current">All Orders</a></li>
            <%} %>
           
           
           <% if(admin==null && customer!=null ){ %> 
           <li><a href="index.jsp" class="current">Home</a></li>
            <li><a href="CustomerServlet" class="current">My Profile</a></li>
            <li><a href="CartServlet?process=myCart" class="current">My Cart</a></li>
    		<li><a href="OrderServlet?process=myorderhistory" class="current">My Orders</a></li>
    		<li><a href="CustomerServlet?process=changepassword" class="current">Change Password</a></li>	
    	 <%} %>
    	 
    	 
    	 
    	 <% if(admin!=null || customer!=null ){ %> 
            <li><a href="LoginServelt?process=LogOut" class="current">Log Out</a></li>
    	 <%} %>
    	 
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>25%</span> discounts for
        purchase over Rs. 500
        	</p>
			<a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>MahaBharat</li>
                <li>The Bad Guys</li>
                <li>Silicon Valley</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->
    
    <div id="templatemo_content">


</body>
</html>