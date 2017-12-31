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
<title>${collection.title}</title>
</head>
<body>
	<div><a href='<spring:url value="/"/>'><span class="fa fa-home"></span> Home</a></div>
	<table class="${collection}">
		<thead>
			<tr>
				<c:forEach items="${collection.fields}" var="field">
					<th class="${field}">
						${field.title}
						<c:if test="${field.decorator != null}">${field.getDecorator(items)}</c:if>
					</th>
				</c:forEach>
				<th class="buttons">#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
				<tr>
					<c:forEach items="${collection.fields}" var="field">
						<td class="${field}">${item[field]}</td>
					</c:forEach>
					<td class="buttons"><a href='<spring:url value="${collection}/edit/${item.id}"/>'><span class="fa fa-pencil"></span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form method="POST">
		<fieldset>
			<legend>Ajout ${collection.title}</legend>
			<c:forEach items="${collection.fields}" var="field">
				<div>
					<label for="${field}">${field.title}</label>
					<c:choose>
						<c:when test="${field.type == 'string'}">
							<input type="text" name="${field}" required="required">
						</c:when>
						<c:when test="${field.type == 'bool'}">
							<input type="checkbox" name="${field}">
						</c:when>
						<c:when test="${field.type == 'integer'}">
							<input type="number" name="${field}" required="required">
						</c:when>
						<c:otherwise>TODO</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>
			<div>
				<input type="submit" value="Ajouter">
			</div>
		</fieldset>
	</form:form>
</body>
</html>