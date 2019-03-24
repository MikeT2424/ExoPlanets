<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exoplanet Explorer</title>
</head>

<body>
	<form method="post"
		action="${pageContext.request.contextPath}/showPlanets">
		<label>Main page of the exoplanets project.</label>
		<p />
		<c:out value="${sessionName}"></c:out>
		<p />
		<c:out value="${modelName}"></c:out>

		Search by:
		<p />
        Default(ID)<input checked="checked" type="radio" name="searchType" value="default">
		Mass: <input type="radio" name="searchType" value="mass">
		Radius: <input type="radio" name="searchType" value="radius">
		Period: <input type="radio" name="searchType" value="period">
		Year: <input type="radio" name="searchType" value="year">
		<p />
		<p />
		<p />
		<!-- Note below that the sf:errors allow the validation errors to show up when attempting to enter inputs -->
		From:_<input type="number" name="from" value="0" />
		<p />
		To:___<input type="number" name="to" value="600" />
		<p />
		<!-- if the form inputs are not set correctly this JSTL if statement will show the errorMessage. -->
		<c:if test="${errorMessage != null}">
			<c:out  value="${errorMessage}"></c:out>
		</c:if>


		<p />
		*****<input value="G0" type="submit">*****
		<p />



		<!-- name to parameter for the sort order which can be changed in the showPlanets JSP. -->
		<input value="default" name="sort" type="hidden">
	</form>
	
	
	
	<!--  Using a JSTL url value: <a href="<c:url value="/"/>">Reload</a> <form method="post" action="${pageContext.request.contextPath}/showPlanets">  -->

</body>

</html>