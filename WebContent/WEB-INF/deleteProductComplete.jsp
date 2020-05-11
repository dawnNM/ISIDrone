<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

    <!-- Page Content -->
    <div class="container">
	  	<div class="alert alert-success" role="alert">
	  		<%
			Integer rv = (Integer) request.getAttribute("returnIntAfterDeletingProduct");
	  		
	  		if(rv>0){
		  		out.println("Product Deleted successfully.");
	  		}
	  		else
	  		{
		  		out.println("Error ... Product not Deleted.");
	  		}
	  		%>
	  	</div>
    </div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>