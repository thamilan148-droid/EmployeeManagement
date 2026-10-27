```jsp
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>

    <h2>Employee List</h2>

    <c:if test="${not empty message}">
        <p style="color: green;">
            <c:out value="${message}" />
        </p>
    </c:if>

    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Salary</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                    <td><c:out value="${employee.email}" /></td>
                    <td><c:out value="${employee.department}" /></td>
                    <td><c:out value="${employee.salary}" /></td>
                </tr>
            </c:forEach>

            <c:if test="${empty employees}">
                <tr>
                    <td colspan="5">No employees found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <br>

    <a href="${pageContext.request.contextPath}/employees/register">
        Register New Employee
    </a>

</body>
</html>
