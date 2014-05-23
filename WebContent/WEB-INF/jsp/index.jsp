<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div align="center">
		<div id="loginForm">
		<form:form action="signin" commandName="userBean">
			
				<table>
					<tr>
						<td><form:label for="email" path="email">Email :</form:label></td>
						<td><form:input type="text" path="email" /></td>
					</tr>
					<tr>
						<td><form:label for="password" path="password">Password :</form:label></td>
						<td><form:input type="password" path="password" /></td>
					</tr>
					<tr>
						<td><input type="submit" id="submit" value="Sign In" /></td>
						<td><input type="button" id="registerNow" value="Register Now" /></td>
					</tr>
				</table>
			
		</form:form>
		</div>
		<hr>
		<div id="registerForm">
			<form:form action="registeruser" commandName="userBean">
				<table>
						<tr>
							<td><form:label for="email" path="email">Email :</form:label></td>
							<td><form:input type="text" path="email" /></td>
						</tr>
						<tr>
							<td><form:label for="password" path="password">Password :</form:label></td>
							<td><form:input type="password" path="password" /></td>
						</tr>
						<tr>
							<td><form:label for="firstName" path="firstName">FirstName :</form:label></td>
							<td><form:input type="firstName" path="firstName" /></td>
						</tr>
						<tr>
							<td><form:label for="lastName" path="lastName">LastName :</form:label></td>
							<td><form:input type="lastName" path="lastName" /></td>
						</tr>
						<tr>
							<td><form:label for="mobileNo" path="mobileNo">MobileNo :</form:label></td>
							<td><form:input type="mobileNo" path="mobileNo" /></td>
						</tr>
						<tr>
							<td><input type="submit" id="register" value="Register" /></td>
						</tr>
					</table>
			</form:form>
		</div>
	</div>
</body>
</html>