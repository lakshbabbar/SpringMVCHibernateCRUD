<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Student</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Student</h1>
		<form:form action="saveStudent" method="post" modelAttribute="student">
			<table>
				<form:hidden path="id" />
				<tr>
					<td>Roll Num:</td>
					<td><form:input path="rollNum" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><form:input path="age" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:input path="gender" /></td>
				</tr>
				<tr>
					<td>Country</td>
					<td><form:select path="country">
							<option value="india">India</option>
							<option value="america">America</option>
							<option value="germany">Germany</option>
							<option value="australia">Australia</option>
		  			France<option value="france">
						</option>
							</form:select></td>
				</tr>
				<tr>
					<td>Date</td>
					<td><form:input type="date" path="dateofjoin" /></td>
				</tr>
				<tr>
				<td>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>