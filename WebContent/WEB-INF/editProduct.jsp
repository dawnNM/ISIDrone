<%@page import="util.Misc"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.net.URLEncoder"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>


<!-- Page Content -->
<div class="container" style="width:500px; text-align:center;">

	  	<form action="modifyProduct" method="post" class="panel panel-primary form-horizontal">
	  		<div class="panel-heading">
	  			<h3 class="panel-title">Modify product</h3>
	  		</div>
	  		<div class="panel-body">
		  		<fieldset>
		  			<legend>Modify Product Information</legend>
		  			
		  			<div class="form-group">
						<div class="col-sm-12">
							<label for="productId" class="col-sm-8 control-label">Product Id</label>
							<input type="number" id="productId" class="form-control" name="productId" placeholder="Id" value = <%=request.getParameter("pid") %> required />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="productCategory" class="col-sm-8 control-label">Product Category</label>
							<input type="number" id="productCategory" class="form-control" name="productCategory" placeholder="Category" value = <%=request.getParameter("pcategory") %>  required />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="productName" class="col-sm-8 control-label">Product Name</label>
							<input type="text" id="productName" class="form-control" name="productName" placeholder="Name" value = <%=request.getParameter("pname") %> required />
						</div>
					</div>

					<div class="form-group">	
						<div class="col-sm-12">
							<label for="productDescription" class="col-sm-8 control-label">Product Description</label>
							<input type="text" id="productDescription" class="form-control" name="productDescription" placeholder="Description" value = <%= request.getParameter("pdescription") %> required />
						</div>
					</div>

					<div class="form-group">	
						<div class="col-sm-12">
							<label for="productPrice" class="col-sm-8 control-label" style="padding-top: 0px;">Product Price</label>
							<input type="number" id="productPrice" class="form-control" name="productPrice" placeholder="1.00" step="0.01" min="0" max="100" value = <%=request.getParameter("pprice") %> required />
<!-- 							<input type="text" id="productPrice" class="form-control" name="productPrice" placeholder="Price" required />
 -->						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="serialNumber" class="col-sm-8 control-label">Serial Number</label>
							<input type="text" id="serialNumber" class="form-control" name="serialNumber" placeholder="serialNumber" value = <%=request.getParameter("pserialnumber") %> required />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="imageName" class="col-sm-8 control-label" style="padding-top: 0px;">Image Name</label>
							<input type="text" id="imageName" class="form-control" name="imageName" placeholder="ImageName" value = <%=request.getParameter("pimgname") %> required />
						</div>
					</div>
					
					<div class="form-group">			
						<div class="col-sm-12">
							<label for="stockQty" class="col-sm-8 control-label">Stock Quantity</label>
							<input type="number" id="stockQty" class="form-control" name="stockQty" placeholder="StockQuantity" value = <%=request.getParameter("pstockqty") %> required />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<label for="isActive" class="col-sm-8 control-label">isActive</label>
							<input type="text" id="isActive" class="form-control" name="isActive" placeholder="isActive (True/False)" value = <%=request.getParameter("pisactive") %> required />
 						</div>
					</div>
					
				</fieldset>
				
				<div class="form-group text-center" style="clear: left; top: 15px; margin-bottom: 15px;">
						<button type="submit" class="btn btn-default">Modify Product</button>
				</div>
			</div>
		</form>
    </div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
