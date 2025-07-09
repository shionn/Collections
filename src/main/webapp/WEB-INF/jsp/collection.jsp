<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">

<table>
	<thead>
		<tr>
			<th colspan="${collection.model.fields.size()+1}">${collection.name}</th>
		</tr>
		<tr>
			<c:forEach items="${collection.model.fields}" var="f">
				<th>${f.title}</th>
			</c:forEach>
			<th><a href='<spring:url value="/${collection.id}/add"/>'>Ajouter</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${collection.items}" var="i">
			<tr>
				<c:forEach items="${collection.model.fields}" var="f">
					<td>${f.present(i)}</td>
				</c:forEach>
				<td><a href='<spring:url value="/${collection.id}/${i.id}/edit"/>'>Editer</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table><br/>

<c:forEach items="${collection.groups}" var="c">
	<table>
		<thead>
			<tr>
				<th colspan="${c.model.fields.size()+1}">${c.name}</th>
			</tr>
			<tr>
				<c:forEach items="${c.model.fields}" var="f">
					<th>${f.title}</th>
				</c:forEach>
				<th><a href='<spring:url value="/${c.id}/add"/>'>Ajouter</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${c.items}" var="i">
				<tr>
					<c:forEach items="${c.model.fields}" var="f">
						<td>${f.present(i)}</td>
					</c:forEach>
					<td><a href='<spring:url value="/${c.id}/${i.id}/edit"/>'>Editer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table><br/>
</c:forEach>

</jsp:attribute>
</t:template>