<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" href="<spring:url value="/css/generated/style.css"/>" />
<title>Collection Login</title>
</head>
<body>
	<form method="POST">
		<fieldset>
			<div>
				<label for="username">Mail:</label> <input name="username" type="email" />
			</div>
			<div>
				<label for="password">Pass:</label> <input name="password" type="password" />
			</div>
			<div>
				<input type="submit" value="Connexion" />
			</div>
		</fieldset>
	</form>
</body>
</html>
