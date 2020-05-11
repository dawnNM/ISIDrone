<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

    <!-- Page Content -->
    <div class="container">
    
    <style>
    table {width:100% }
    table ,tr,th,td{border:2px solid grey;font-size:18px;font-family:serif;}
    th,td{text-align: center;}
    </style>
    <%
    out.println("Order Details : ");
    %>
	<table style="margin:0 auto" class="table table-striped">
        <thead>
            <tr style="background-color: #414854 ;color:white">
                <th>OrderId</th>
                <th>ProductId</th>
                <th>Quantity</th>
                <th>User_Id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Date</th>
                <th>IsShipped</th>
                <th>Delete</th>
                <th>Change Shipping Status</th>
            </tr>
        </thead>
    	<tbody>
	
			<tr>
                <td width="5%"><%=Integer.parseInt(request.getParameter("oid"))%></td>
                <td width="5%"><%=Integer.parseInt(request.getParameter("pid"))%></td>
                <td width="5%"><%=Integer.parseInt(request.getParameter("qty"))%></td>
                <td width="5%"><%=Integer.parseInt(request.getParameter("uid"))%></td>
                <td width="10%"><%=request.getParameter("fn")%></td>
                <td width="10%"><%=request.getParameter("ln")%></td>
                <td width="15%"><%=request.getParameter("dt")%></td>
                <td width="5%"><%=request.getParameter("isshpd")%></td>
                <td width="15%"><a href="deleteOrder?oid=<%= Integer.parseInt(request.getParameter("oid"))%>">Delete</a></td>
                <td width="25%"><a href="changeShippingStatusOrder?oid=<%= Integer.parseInt(request.getParameter("oid"))%>&isShipped=<%= Boolean.parseBoolean(request.getParameter("isshpd"))%>">Change Shipping Status</a></td>
            </tr>
            
		</tbody>
    </table>
    
    </div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>