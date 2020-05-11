<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

    <!-- Page Content -->
    <div class="container">
	  	<div class="alert alert-success" role="alert">
	  		<%
			Integer rv = (Integer) request.getAttribute("returnIntAfterChangingIsShipped");
	  		
	  		if(rv>0){
		  		out.println("Ishipped status of Order changed successfully.");
	  		}
	  		else
	  		{
		  		out.println("Error ... Isshipped status not changed.");
	  		}
	  		%>
	  	</div>
    </div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>