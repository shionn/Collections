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
			<th>Date</th><th>Collection</th><th>Description</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="i">
			<tr>
				<td><fmt:formatDate value="${i.updated}" pattern="dd/MM/yyyy"/></td>
				<td>${i.collection.name}</td>
				<td>
					<c:forEach items="${i.collection.model.fields}" var="f" varStatus="s">
						${f.present(i)}<c:if test="${not s.last}">, </c:if>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</jsp:attribute>
</t:template>