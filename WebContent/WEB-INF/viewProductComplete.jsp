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
    out.println("Product Details : ");
    %>
	<table style="margin:0 auto" class="table table-striped">
        <thead>
            <tr style="background-color: #414854 ;color:white">
                <th>ProductId</th>
                <th>Category</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Sr.No.</th>
                <th>ImgName</th>
                <th>StockQty</th>
                <th>IsActive</th>
                <th>Delete</th>
            </tr>
        </thead>
    	<tbody>
	
			<tr>	
                <td width="5%"><%=Integer.parseInt(request.getParameter("pid"))%></td>
                <td width="5%"><%=Integer.parseInt(request.getParameter("pcategory"))%></td>
                <td width="5%"><%=request.getParameter("pname")%></td>
                <td width="5%"><%=request.getParameter("pdescription")%></td>
                <td width="10%"><%=Float.parseFloat(request.getParameter("pprice"))%></td>
                <td width="10%"><%=request.getParameter("pserialnumber")%></td>
                <td width="15%"><%=request.getParameter("pimgname")%></td>
                <td width="15%"><%=request.getParameter("pstockqty")%></td>
                <td width="5%"><%=Boolean.parseBoolean(request.getParameter("pisactive"))%></td>
                <td width="15%"><a onclick="return confirm('Are you sure?')" href="deleteProduct?pid=<%= Integer.parseInt(request.getParameter("pid"))%>">Delete</a></td>
            </tr>
            
		</tbody>
    </table>
    
    </div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>