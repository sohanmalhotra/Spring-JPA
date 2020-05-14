<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@page import="java.util.*" %>
    <%@page import="com.example.truyumm.model.*"  %>

<!DOCTYPE html>
<html>
	<head>
		<title>truYum</title>
		<link rel="icon" type="image/ico" href="./images/truyum-logo-dark.png" />
		<link rel="stylesheet" type="text/css" href="./style/style.css">
	</head>
	<body>
		<header>
			<span class="header-title">truYum</span>
			<img class="header-logo" src="./images/truyum-logo-light.png" alt="truYum Logo"></img>
			<nav>
				<a class="nav-link" href="./menu-item-list-customer">Menu</a>
				<a class="nav-link" href="./cart">Cart</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Cart</h2>
			
<% List<Cart> l=(List<Cart>)request.getAttribute("cartlist");
float total=0;%>
			<p class="article-notification article-notification-left">Item removed from Cart Successfully</p>
			<br>
			<table class="table-margin">
				<tr>
					<th class="col-left">Name</th>
					<th class="col-left">Free Delivery</th>
					<th class="col-right">Price</th>
					<th></th>
				</tr>
				
				<%for(Cart c:l) {%>
				<%total=total+c.getPrice();%>
				<tr>
					<td class="col-left"><%=c.getName()%></td>
					<td class="col-left"><%=c.getFreedelivery()%></td>
					<td class="col-right"><%=c.getPrice()%></td>
					<td>
						<a class="action-link" href="./cart-notification?id=<%=c.getId()%>">Delete</a>
					</td>
				</tr>
				<%} %>
				<!--  
				<tr>
					<td class="col-left">Burger</td>
					<td class="col-left">No</td>
					<td class="col-right">Rs. 129.00</td>
					<td>
						<a class="action-link" href="./cart-notification.html">Delete</a>
					</td>
				</tr>-->
				<tr>
					<th></th>
					<th class="col-left">Total</th>
					<th class="col-right">Rs. <%=total%></th>
					<th></th>
				</tr>
			</table>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
	</body>
</html>