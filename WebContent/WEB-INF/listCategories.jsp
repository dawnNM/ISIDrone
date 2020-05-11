<%@page import="java.text.DecimalFormat"%>
<%@page import="entities.Item"%>
<%@page import="action.ActionCategory"%>
<%@page import="java.util.ArrayList, entities.Category"%>
<%@page import="entities.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%
	//Format a deux decimal
	@SuppressWarnings("unchecked")
ArrayList<Category> category = (ArrayList<Category>) request.getAttribute("categories");
//System.out.print(category.get(0).getName());
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
	<!-- /.container -->
    <!-- Page Content -->
    <div class="container">
    <style>
    table ,tr,th,td{border:2px solid grey;font-size:18px;font-family:serif;}
    th,td{width:150px; text-align: center;}
    </style>
		<table style="margin:0 auto; width:300px">
		     <tr style="background-color: #414854 ;color:white">
		     	<th>Name</th><th>order</th><th>Edit</th><th>Delete</th>
		     </tr>
		     <% 
		     DecimalFormat df = new DecimalFormat("####0.00");
				
				if(!category.isEmpty()) {
				for(Category cat : category) {
		     %>
		
			<tr>
				
				<td><%=cat.getName()%></td>
				<td><%=cat.getorder() %></td>
				<td><a href='modifycategory?v=<%= cat.getId()%>'>Edit</a></td>
				<td><a onclick="return confirm('Are you sure?')" href="deletecategory?v=<%= cat.getId()%>">Delete</a></td>
			</tr>	
			<%
				}
			}
				else{
					%>
					<div class="alert alert-info">
				Aucun produit en vedette pour le moment.
			</div>
			<%
				}
			%>    
		
		</table>
    </div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>