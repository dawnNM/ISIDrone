<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Cart"%>
<%@page import="entities.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%
	@SuppressWarnings("unchecked")
	//ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("featuredProduct");
	String error = (String)request.getAttribute("error");
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
	<!-- /.container -->
    <!-- Page Content -->
    <div class="container">
		<div class="row">
		<%if(error!=null )
			{%><h2>cannot use this position .Already have one category on this position</h2><%
			}
			%>
			
		</div>
        <div class="row">
			<form action="addCategory" method="post" class="panel panel-primary form-horizontal" style="float: unset; margin: auto;">
	<div class="panel-heading">
		<h3 class="panel-title">Add new Category</h3>
	</div>
	<style>
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

.switch input { 
  opacity: 0;
  width: 0;
  height: 0;
}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</style>
	<div class="panel-body">
		<fieldset class="col-sm-10 col-lg-10 col-md-10">
			<legend>Information of new category</legend>
			<div class="form-group">
				<label for="name">Name: </label>
				<input type="text" id="login" class="form-control" name="name" required />
			</div>
			
			<div class="form-group">
				<label for="description">description </label>
				<input type="text" id="password" class="form-control" name="description" required />
			</div>
			<div class="form-group">
				<label for="position">Position </label>
				<input type="number" id="password" class="form-control" name="position" required />
			</div>
			<div class="form-group">
			
				<label class="switch">
  					<input type="checkbox" name="isactive" value="yes" required >
 					<span class="slider round"></span>
				</label>
			</div>
			<button type="submit" class="btn btn-default">Add new category</button>
		</fieldset>
	</div>
</form>
           
        </div>

    </div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>