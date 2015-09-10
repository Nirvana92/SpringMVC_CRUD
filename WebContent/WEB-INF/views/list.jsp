<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		});
	});
</script>
</head>
<body>
	<c:if test="${empty employees }">
		没有员工
	</c:if>
	
	<c:if test="${!empty employees }">
			<table border="1" cellspacing="0" cellpadding="10">
				<tr>
					<th>ID</th>
					<th>LASTNAME</th>
					<th>EMAIL</th>
					<th>GENDER</th>
					<th>DEPARTMENT</th>
					<th>EDIT</th>
					<th>DELETE</th>
				</tr>
				<c:forEach items="${employees }" var="emp">
					<tr>
						<td>${emp.id }</td>
						<td>${emp.lastName }</td>
						<td>${emp.email }</td>
						<td>${emp.gender eq 0 ? 'FEMALE' : 'MALE' }</td>
						<td>${emp.department.departmentName }</td>
						<td><a href="emp/${emp.id }">EDIT</a></td>
						<td><a class='delete' href="emp/${emp.id }">DELETE</a></td>
					</tr>
				</c:forEach>
			</table>
	</c:if>
	
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	
	<br/>
	<br/>
	<a href="emp">add employee</a>
</body>
</html>