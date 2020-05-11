<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "model.Product" %>

<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<div class="container">
    <style>
    table {width:100% }
    table ,tr,th,td{border:1px solid black;font-size:18px;font-family:serif;}
    th,td{text-align: center;}
    </style>


<!-- 	<script>
		function boolean popup() {
  		var txt;
  		var r = confirm("Please Confirm!");
  		if (r == true) {
    		txt = "You pressed OK!";
  		} else {
    		txt = "You pressed Cancel!";
  		}
  		return r;
  		//document.getElementById("demo").innerHTML = txt;
		}
	</script> -->

	<table style="margin:0 auto;" class="table table-striped">
        <thead>
            <tr style="background-color: #414854 ;color:white">
                <th>Id</th>
                <th>Category</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Sr.No.</th>
                <th>ImgName</th>
                <th>StockQty</th>
                <th>IsActive</th>
                <th>Delete</th>
                <th>Modify</th>
                <th>Details</th>
            </tr>
        </thead>
    	<tbody>

	<% 
		ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("productList");
	%>
	
	<%
		for(Product product : list) 
		{
		%>
	
			<tr>
                <td width="5%"><%=product.getId()%></td>
                <td width="5%"><%=product.getCategory()%></td>
                <td width="10%"><%=product.getName()%></td>
                <td width="40%"><%=product.getDescription()%></td>
                <td width="5%"><%=product.getPrice()%></td>
                <td width="5%"><%=product.getSerialNumber()%></td>
                <td width="5%"><%=product.getImgName()%></td>
                <td width="5%"><%=product.getStockQty()%></td>
                <td width="5%"><%=product.isActive()%></td>
                <td width="5%"><a onclick="return confirm('Are you sure?')" href="deleteProduct?pid=<%= product.getId()%>">Delete</a></td>
            	<td width="5%"><a href="modifyProduct?pid=<%= product.getId()%>&pcategory=<%= product.getCategory()%>&pname=<%= product.getName()%>&pdescription=<%= "'"+ product.getDescription() + "'" %>&pprice=<%= product.getPrice()%>&pserialnumber=<%= product.getSerialNumber()%>&pimgname=<%= product.getImgName()%>&pstockqty=<%= product.getStockQty()%>&pisactive=<%= product.isActive()%>">Modify</a></td>
            	<td width="5%"><a href="viewProduct?pid=<%= product.getId()%>&pcategory=<%= product.getCategory()%>&pname=<%= product.getName()%>&pdescription=<%= "'"+ product.getDescription() + "'" %>&pprice=<%= product.getPrice()%>&pserialnumber=<%= product.getSerialNumber()%>&pimgname=<%= product.getImgName()%>&pstockqty=<%= product.getStockQty()%>&pisactive=<%= product.isActive()%>">View</a></td>            
            </tr>
	    <%
		}
	%>
		</tbody>
    </table>
	
</div>

<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>