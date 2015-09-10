<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<f:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
		<!-- lastName不能修改 -->
		<c:if test="${employee.lastName ==null }">
			LASTNAME: <f:input path="lastName"/><br/>
		</c:if>
		
		<c:if test="${employee.lastName != null }">
			<!-- controller 中的@ModelAttribute获取的参数 -->
			<f:hidden path="id" />
			
			<input type="hidden" name="_method" value="PUT" />
		</c:if>
		
		EMAIL: <f:input path="email"/><br/>
		GENDER: <f:radiobuttons path="gender" items="${genders }" delimiter="<br/>"/><br/>
		DEPARTMENT: <f:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id" /><br/>
		<input type="submit" value="add department" />		
	</f:form>
</body>
</html>