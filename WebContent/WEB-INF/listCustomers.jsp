<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "entities.Order" %>
<%@page import = "model.User2" %>

<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<div class="container">
	<% out.println("List of Customers:"); %>
    <style>
    table {width:100% }
    table ,tr,th,td{border:1px solid grey;font-size:18px;font-family:serif;}
    th,td{text-align: center;}
    </style>
	<table style="margin:0 auto" class="table table-striped">
        <thead>
            <tr style="background-color: #414854 ;color:white">
                <th>UserId</th>
                <th>lastName</th>
                <th>firstName</th>
                <th>email</th>
                <th>View Details</th>
                <th>Delete</th>
            </tr>
        </thead>
    	<tbody>

	<% 
		ArrayList<User2> list = (ArrayList<User2>) request.getAttribute("customerList");
	%>
	
	<%
		for(User2 user : list) 
		{
		%>
	
			<tr>
                <td width="15%"><%=user.getId()%></td>
                <td width="15%"><%=user.getFirstName()%></td>
                <td width="15%"><%=user.getLastName()%></td>
                <td width="15%"><%=user.getEmail()%></td>
                <td width="20%"><a href="viewUser?uid=<%= user.getId()%>">View Details</a></td>
                <td width="20%"><a onclick="return confirm('Are you sure?')" href="deleteUser?uid=<%= user.getId()%>">Delete</a></td>
            </tr>
	    <%
		}
	%>
		</tbody>
    </table>
	
</div>

<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>