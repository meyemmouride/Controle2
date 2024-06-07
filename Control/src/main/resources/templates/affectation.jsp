<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Assignment</title>
</head>
<body>
<h2>Assign Employee to Project</h2>
<form action="/assign" method="post">
    <label for="employeeId">Employee:</label>
    <select name="employeeId" id="employeeId">
        <c:forEach var="employee" items="${employees}">
            <option value="${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
    <label for="project">Project:</label>
    <input type="text" name="project" id="project" required>
    <button type="submit">Assign</button>
</form>
</body>
</html>
