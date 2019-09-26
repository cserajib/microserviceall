<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
	<title>Login Page</title>
</head>
<body>

	<c:if test="${param.error != null}">
		<div  style="color: red;">
		Failed to login.
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
			Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</c:if>
		</div>
	</c:if>
	
	<c:if test="${param.logout != null}">
		<div style="color: red;" >
		You have been logged out.
		</div>
	</c:if>
	
	<c:url value="/mylogin" var="loginUrl"/>
	
	<form action="${loginUrl}" method="post">
		User Name <input type="text" name="myusername" /> <br/>
		Password <input type="password" name="mypassword" /> <br/>
		<input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}"/>
		<!-- <input type="checkbox" name="_spring_security_remember_me" /> -->
		<input type="submit" value="Login" />
	</form>

</body>
</html>