<%@page import="util.Const"%>
<%@page import="manager.MLogin"%>
<%@page import="action.ActionLogin"%>
<%@page import="manager.MCookies"%>
<%@ page import="entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//S'il n'y a pas d'utilisateur déjà de connecté
// If there is no user already connected
User user = (User)session.getAttribute("user");

//S'il n'y a pas d'utilisaeur de connecté présentement, on vérifie dans les cookies
// et si nous somme pas en train de nous déconnecter

// If there is no user currently connected, we check in cookies and if we are not disconnecting
if(user == null && request.getAttribute("logout") == null) {
	user = ActionLogin.getUserFromAutoLogin(request);
	session.setAttribute("user", user);
}

//Si le autoLogin a fonctionné -- If the autoLogin worked
if(user != null) {%>
<li id="loginState">
	<a href="#" id="user"><%=user.getFirstName()%></a>
<%if(user.getUsertype().equalsIgnoreCase("customer"))
	{
	%>
	<ul id="userAction" class="list-unstyled navbar navbar-default">
		<li><a href="<%="order-history"%>">Historique commande</a></li>
		<li>&nbsp;</li>
		<li><a href="login">Déconnexion</a></li>
	</ul><%
	}
	else
	{
		%><ul id="userAction" class="list-unstyled navbar navbar-default">
		
		<li>&nbsp;</li>

		<li><a href="addaproduct">Add Product</a></li>
		<li><a href="deleteaproduct">Delete Product</a></li>
		<li><a href="modifyProduct">Modify Product</a></li>
		<li><a href="getAllProducts">Display all Products</a></li>
		<li><a href="displayproduct">Search Product</a></li>		
		<li>&nbsp;</li>
		<li>&nbsp;</li>
		
		<li><a href="addCategory">Add Category</a></li>
		<li><a href="listCategories">Display Categories</a></li>
		<li>&nbsp;</li>
		<li>&nbsp;</li>
		
		<li><a href="getAllOrders">Display All Orders</a></li>
		<li>&nbsp;</li>
		<li>&nbsp;</li>
		
		<li><a href="GetAllUsersController">Display All Customers</a></li>
		<li>&nbsp;</li>
		<li>&nbsp;</li>
		
				
		<li><a href="login">Déconnexion</a></li>
	</ul><%
	}%>
	
</li>
<% }
else
{
	
%>
<li><a href="signup<%=(request.getParameter("fromCart") != null ? "?fromCart=true" : "")%>">S'enregistrer</a></li>
<li id="loginState"><a href="login">Connexion</a></li>
<%	
}
%>