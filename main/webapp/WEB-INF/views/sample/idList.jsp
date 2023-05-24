<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>id List</h1>

<c:forEach var="id" items="${idList}">
	${id}<br />	
</c:forEach>