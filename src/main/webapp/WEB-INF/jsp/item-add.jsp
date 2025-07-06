<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">

<spring:url value="/${collection.id}/add" var="url"/>
<form:form method="POST" action="${url}">
	<c:forEach items="${collection.model.fields}" var="f">
		<label>${f.title}</label>
		<input placeholder="${f.title}" name="${f.field}"/>
	</c:forEach>
	<input type="submit" value="Ajouter">
</form:form>

</jsp:attribute>
</t:template>