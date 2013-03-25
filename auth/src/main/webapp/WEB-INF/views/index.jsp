<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>Demo</title>
	<script src="${ctx}/static/auth/1.0/index.js" type="text/javascript"></script>
</head>

<body>
	<div id="mainTabs" >
		<ul >
			<li ><a href="#mainTab" >首 页</a></li>
		</ul>
		<div id='mainTab'>
		 <p> this is a pag </p>
		</div>
	</div>
</body>
</html>
