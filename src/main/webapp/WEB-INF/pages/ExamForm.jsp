<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h1>New/Edit Exam</h1>
		<form:form action="saveExam" method="post" modelAttribute="exam">
			<table>
				<form:hidden path="examid" />
				<tr>
					<td>Subject Name:</td>
					<td><form:input path="subjectname" /></td>
				</tr>
				<tr>
					<td>Marks:</td>
					<td><form:input path="marks" /></td>
				</tr>
				<tr>
					<td>Student Id:</td>
					<td><form:input path="studentid" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>