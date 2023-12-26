<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="minilib.vo.CodeBookType"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加图书</title>
</head>
<body>
${message}
<form  action="addTitleManageTitlesAction.action" method="post">


 
图书类别：
 
 <select name="book.typeid" >
 	<c:forEach items = "${requestScope.alltypelist}"  var = "booktype" varStatus = "status"> 
	<option value = "${booktype.codeId}">${booktype.codeName}   </option>
	</c:forEach>
</select><br>

书名：
<input type="text" name="book.title" >
<br>
<input type="submit" name = "sumbit" value = "增加图书">


</form>
</body>
</html>