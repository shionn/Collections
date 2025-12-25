<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ page import="collections.db.dbo.ItemField" %>
<%@ page import="collections.db.dbo.Console" %>
<t:template>
<jsp:attribute name="content">

<spring:url value="/${collection.id}/${item.id}/edit" var="url"/>
<form:form method="POST" action="${url}">
	<c:forEach items="${collection.model.fields}" var="f">
		<c:choose>
			<c:when test="${f.bool}">
				<input type="checkbox" name="${f.field}" <c:if test="${item[f.field]}">checked="checked"</c:if>/>
				<label for="${f.field}">${f.title}</label>
			</c:when>
			<c:when test="${f == ItemField.console}">
				<label for="${f.field}">${f.title}</label>
				<select  name="${f.field}">
					<c:forEach items="${Console.values()}" var="c">
						<option value="${c}" <c:if test="${c == item[f.field]}">selected="selected"</c:if>>${c}</option>
					</c:forEach>
				</select>
			</c:when>
			<c:otherwise>
				<label for="${f.field}">${f.title}</label>
				<input placeholder="${f.title}" name="${f.field}" value="${item[f.field]}"/>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<br><input type="submit" value="Editer">
	<spring:url value="/${collection.id}/${item.id}/delete" var="url"/>
	<br/>
	<a href="${url}">Supprimer</a>
</form:form>

</jsp:attribute>
</t:template>