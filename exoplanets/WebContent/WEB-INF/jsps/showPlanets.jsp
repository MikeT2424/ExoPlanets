<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Planets</title>
</head>
<body>

	<form method="get" action="<c:url value="/sortPlanets"/>">

		<table border="1">
			<!-- These rows of buttons will sort the list without a new MySQL Query using the sortPlanets handler in the controller -->
			<tr>
				<td><input value="sortIDa" type="submit" name="sort"></td>
				<td><input value="sortNameAsc" type="submit" name="sort"></td>
				<td><input value="sortMassAsc" type="submit" name="sort"></td>
				<td><input value="sortRadiusAsc" type="submit" name="sort"></td>
				<td><input value="sortPeriodAsc" type="submit" name="sort"></td>
				<td><input value="sortYearAsc" type="submit" name="sort"></td>
				<td><input value="sortDistanceAsc" type="submit" name="sort"></td>
			</tr>
			<tr>
				<td><input value="sortIDr" type="submit" name="sort"></td>
				<td><input value="sortNameDesc" type="submit" name="sort"></td>
				<td><input value="sortMassDesc" type="submit" name="sort"></td>
				<td><input value="sortRadiusDesc" type="submit" name="sort"></td>
				<td><input value="sortPeriodDesc" type="submit" name="sort"></td>
				<td><input value="sortYearDesc" type="submit" name="sort"></td>
				<td><input value="sortDistanceDesc" type="submit" name="sort"></td>
			</tr>

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
		
		
	</form>
	

	<a href="<c:url value="/printPlanets"/>">*Printable planets list*</a>
	

</body>
</html>