	<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration</title>
</head>
<body>
<h2>Employee Registration Form</h2>
<form:form action="${pageContext.request.contextPath}/employees/save"
           modelAttribute="employee" method="post">
    <label>Name:</label>
    <form:input path="name"/>
    <form:errors path="name" cssStyle="color:red"/>
    <br><br>

    <label>Email:</label>
    <form:input path="email"/>
    <form:errors path="email" cssStyle="color:red"/>
    <br><br>

    <label>Department:</label>
    <form:input path="department"/>
    <form:errors path="department" cssStyle="color:red"/>
    <br><br>

    <label>Salary:</label>
    <form:input path="salary" type="number"/>
    <form:errors path="salary" cssStyle="color:red"/>
    <br><br>

    <button type="submit">Register Employee</button>
</form:form>
<br>
<a href="${pageContext.request.contextPath}/employees">View All Employees</a>
</body>
</html>
