<%@page import="util.Misc"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>


<!-- Page Content -->
<div class="container" style="width:500px; text-align:center;">
<%-- <%
	if(request.getParameter("fromCart") != null){
		%>
			<div class="progress-cart">
				<span class="label label-success">Panier</span>
				<span class="label label-success">Sommaire</span>
				<span class="label label-warning">Compte</span>
				<span class="label label-warning">Facture</span>
			</div>
		<%
	}
%> --%>

<!-- style="float: unset; margin: auto;"
 -->    
	  	<form action="addaproduct" method="post" class="panel panel-primary form-horizontal">
	  		<div class="panel-heading">
	  			<h3 class="panel-title">Adding a new product</h3>
	  		</div>
	  		<div class="panel-body">
		  		<fieldset>
		  			<legend>New Product Information</legend>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="productCategory" class="col-sm-8 control-label">Product Category</label>
							<input type="number" id="productCategory" class="form-control" name="productCategory" placeholder="Category" required />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="productName" class="col-sm-8 control-label">Product Name</label>
							<input type="text" id="productName" class="form-control" name="productName" placeholder="Name" required />
						</div>
					</div>

					<div class="form-group">	
						<div class="col-sm-12">
							<label for="productDescription" class="col-sm-8 control-label">Product Description</label>
							<input type="text" id="productDescription" class="form-control" name="productDescription" placeholder="Description" required />
						</div>
					</div>

					<div class="form-group">	
						<div class="col-sm-12">
							<label for="productPrice" class="col-sm-8 control-label" style="padding-top: 0px;">Product Price</label>
							<input type="number" id="productPrice" class="form-control" name="productPrice" placeholder="1.00" step="0.01" min="0" max="100" required />
<!-- 							<input type="text" id="productPrice" class="form-control" name="productPrice" placeholder="Price" required />
 -->						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="serialNumber" class="col-sm-8 control-label">Serial Number</label>
							<input type="text" id="serialNumber" class="form-control" name="serialNumber" placeholder="serialNumber" required />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="imageName" class="col-sm-8 control-label" style="padding-top: 0px;">Image Name</label>
							<input type="text" id="imageName" class="form-control" name="imageName" placeholder="ImageName" required />
						</div>
					</div>
					
					<div class="form-group">			
						<div class="col-sm-12">
							<label for="stockQty" class="col-sm-8 control-label">Stock Quantity</label>
							<input type="number" id="stockQty" class="form-control" name="stockQty" placeholder="StockQuantity" required />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="isActive" class="col-sm-8 control-label">isActive</label>
							<input type="text" id="isActive" class="form-control" name="isActive" placeholder="isActive (True/False)" required />
 						</div>
					</div>
					



				</fieldset>
<%-- 				<%
				if(request.getParameter("fromCart") != null){
				%>
				<input type="hidden" name="fromCart" value="true">
				<%
					}
				%> --%>
				<div class="form-group text-center" style="clear: left; top: 15px; margin-bottom: 15px;">
						<button type="submit" class="btn btn-default">Add Product</button>
				</div>
			</div>
		</form>
    </div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
