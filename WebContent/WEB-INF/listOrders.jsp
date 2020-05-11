<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "entities.Order" %>
<%@page import = "model.Order2" %>

<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<div class="container">
    <style>
    table {width:100% }
    table ,tr,th,td{border:1px solid grey;font-size:18px;font-family:serif;}
    th,td{text-align: center;}
    </style>
	<table style="margin:0 auto" class="table table-striped">
        <thead>
            <tr style="background-color: #414854 ;color:white">
                <th>OrderId</th>
                <th>ProductId</th>
                <th>User_Id</th>
                <th>FirstName</th>
                <th>Date</th>
                <th>IsShipped</th>
                <th>View Details</th>
                <th>Delete</th>
                <th>Change Shipping Status</th>
            </tr>
        </thead>
    	<tbody>

	<% 
		ArrayList<Order2> list = (ArrayList<Order2>) request.getAttribute("orderList2");
	%>
	
	<%
		for(Order2 order2 : list) 
		{
		%>
	
			<tr>
                <td width="5%"><%=order2.getId()%></td>
                <td width="10%"><%=order2.getProduct_id()%></td>
                <td width="5%"><%=order2.getUser_id()%></td>
                <td width="5%"><%=order2.getFirstName()%></td>
                <td width="15%"><%=order2.getDate()%></td>
                <td width="5%"><%=order2.isShipped()%></td>
                <td width="15%"><a href="viewOrder?oid=<%= order2.getId()%>&pid=<%= order2.getProduct_id()%>&qty=<%= order2.getQty()%>&uid=<%= order2.getUser_id()%>&fn=<%= order2.getFirstName()%>&ln=<%= order2.getLastName()%>&dt=<%= order2.getDate()%>&isshpd=<%= order2.isShipped()%>">View Details</a></td>
                <td width="15%"><a onclick="return confirm('Are you sure?')" href="deleteOrder?oid=<%= order2.getId()%>">Delete</a></td>
                <td width="25%"><a href="changeShippingStatusOrder?oid=<%= order2.getId()%>&isShipped=<%= order2.isShipped()%>">Change Shipping Status</a></td>
            </tr>
	    <%
		}
	%>
		</tbody>
    </table>
	
</div>

<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>