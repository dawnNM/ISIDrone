<%@page import="util.Const"%>
<%@page import="manager.MLogin"%>
<%@page import="action.ActionLogin"%>
<%@page import="manager.MCookies"%>
<%@ page import="entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

User user = (User)session.getAttribute("user");
if(user != null) {
	user = ActionLogin.getUserFromAutoLogin(request);
	session.setAttribute("user", user);
}

if(true) {%>
<li id="productState">
	<a href="#" id="product"><%="Product Menu"%></a>
	<ul id="productAction" class="list-unstyled navbar navbar-default">
		<li><a href="<%="order-history"%>">Add a product</a></li>
		<li><a href="<%="order-history"%>">Delete a product</a></li>
		<li><a href="<%="order-history"%>">Display All Products</a></li>
		<li>&nbsp;</li>
		<li><a href="login">Déconnexion</a></li>
	</ul>
</li>
<% }	
%>