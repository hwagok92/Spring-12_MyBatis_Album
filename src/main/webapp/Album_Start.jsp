<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    webapp\Album_Start.jsp
    
    <%
    	String viewPage = request.getContextPath()+"/list.ab";
    	System.out.println("viewPage:"+viewPage); 
    	
    	response.sendRedirect(viewPage);
    %>