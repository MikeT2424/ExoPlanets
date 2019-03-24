<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Print planets...

	<table border="1">
		<tr>
			<td><b>#</b></td>
			<td><b>Name</b></td>
			<td><b>Mass (x Earth)</b></td>
			<td><b>Radius(x Earth)</b></td>
			<td><b>Period (Days)</b></td>
			<td><b>Discovered</b></td>
			<td><b>Distance (Parsecs)</b></td>
		</tr>
		<c:forEach var="planet" items="${planetList}">
			<tr>
				<td><c:out value="${planet.ID}"></c:out></td>

				<td><c:out value="${planet.name}"></c:out></td>

				<td><c:out value="${planet.mass}"></c:out></td>

				<td><c:out value="${planet.radius}"></c:out></td>

				<td><c:out value="${planet.period}"></c:out></td>

				<td><c:out value="${planet.year}"></c:out></td>

				<td><c:out value="${planet.starDistance}"></c:out></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>