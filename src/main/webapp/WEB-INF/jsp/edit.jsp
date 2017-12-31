<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" href="<spring:url value="/css/generated/style.css"/>" />
<title>${collection.title}edition ${item.id}</title>
</head>
<body>
	<form:form method="POST">
		<input type="hidden" name="id" value="${item.id}">
		<fieldset>
			<legend>Edition ${collection.title}, ${item.id}</legend>
			<c:forEach items="${collection.fields}" var="field">
				<div>
					<label for="${field}">${field.title}</label>
					<c:choose>
						<c:when test="${field.type == 'string' || field.type == 'img'}">
							<input type="text" name="${field}" required="required" value="${item[field]}">
						</c:when>
						<c:when test="${field.type == 'bool'}">
							<input type="checkbox" name="${field}"<c:if test="${item[field]}"> checked="checked"</c:if>>
						</c:when>
						<c:when test="${field.type == 'integer'}">
							<input type="number" name="${field}" required="required" value="${item[field]}">
						</c:when>
						<c:otherwise>TODO</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>
			<div>
				<input type="submit" value="Editer">
			</div>
		</fieldset>
	</form:form>
	<spring:url value="/${collection}/delete/${item.id}" var="action"/>
	<form:form method="POST" action="${action}">
		<input type="hidden" name="id" value="${item.id}">
		<fieldset>
			<legend>Suppression ${collection.title}, ${item.id}</legend>
			<c:forEach items="${collection.fields}" var="field">
				<div>
					<label for="${field}">${field.title}</label>
					<c:choose>
						<c:when test="${field.type == 'string' || field.type == 'img'}">
							<input type="text" name="${field}" readonly="readonly" value="${item[field]}">
						</c:when>
						<c:when test="${field.type == 'bool'}">
							<input type="checkbox" name="${field}"<c:if test="${item[field]}"> checked="checked"</c:if> readonly="readonly">
						</c:when>
						<c:when test="${field.type == 'integer'}">
							<input type="number" name="${field}" readonly="readonly" value="${item[field]}">
						</c:when>
						<c:otherwise>TODO</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>
			<div>
				<input type="submit" value="Supprimer" class="delete">
			</div>
		</fieldset>
	</form:form>
</body>
</html>