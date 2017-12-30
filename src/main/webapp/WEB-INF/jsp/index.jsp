<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" href="<spring:url value="/css/generated/style.css"/>" />
<title>Collections</title>
</head>
<body>
	<ul>
		<c:forEach items="${collections}" var="collection">
			<li><a href='<spring:url value="${collection}"/>'>${collection.title}</a></li>
		</c:forEach>
	</ul>
</body>
</html>