<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>search</h1>

<form action="/spring/sample/pwFind">
	<input type="text" name="id" />
	<input type="submit" value="pw검색" />
</form>
<hr>

<h2>비밀번호 : ${pw}</h2>

<hr>

<form action="/spring/sample/login">
	<input type="text" name="id" /> <br />
	<input type="text" name="pw" /> <br />
	<input type="submit" value="로그인" />
</form>

<hr>

<h2>로그인 : ${result}</h2>

<hr>

<form action="/spring/sample/insert">
	id : <input type="text" name="id" /> <br />
	pw : <input type="text" name="pw" /> <br />
	age : <input type="text" name="age" /> <br />
	birth : <input type="date" name="birth" /> <br />
			<input type="submit" value="전송" /> <br />
</form>





