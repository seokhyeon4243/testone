<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<h1>pro</h1>
	
	<h2>${parameterDTO.id }</h2>
	
	<c:forEach var="a" items="${list }">
		<h3>${a }</h3>
	</c:forEach>
	
	<h2>id = ${id }</h2>
	<h2>pw = ${pw }</h2>
	<h2>age = ${age }</h2>
	<h2>number = ${number }</h2>
	<h2>list = ${list }</h2>