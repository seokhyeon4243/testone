<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<hl>ex11Form</hl>

<%-- view(jsp) 프로젝트명(root path)넣어준다 --%>
<form action="/spring/sample/ex11Pro" method="post" enctype="multipart/form-data">
	file : <input type="file" name="save" accept="image/*" /> <br />
		   <input type="submit" value="업로드" />
</form>

<br />
<hr />

<form action="/spring/sample/ex12Pro" method="post" enctype="multipart/form-data">
	file : <input type="file" name="save" accept="image/*" /> <br />
	file : <input type="file" name="save" accept="image/*" /> <br />
	file : <input type="file" name="save" accept="image/*" /> <br />
		   <input type="submit" value="업로드" accept="image/*" />
</form>