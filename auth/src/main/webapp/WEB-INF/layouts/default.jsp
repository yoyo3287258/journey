<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title><sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
<!--Journey default css-->
<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/operamasks/elegant/om-elegant.css" type="text/css" rel="stylesheet" />
<!--Theme-->
<link href="${ctx}/static/jquery-ui/1.9.2/css/start/jquery-ui-1.9.2.custom.min.css" type="text/css" rel="stylesheet" />
<!--Wijmo Widgets CSS-->
<link href="${ctx}/static/wijmo/2.3.4/css/jquery.wijmo-open.2.3.4.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<!--jquery ui-->
<script src="${ctx}/static/jquery-ui/1.9.2/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>
<!--wijmo widgets-->
<script src="${ctx}/static/wijmo/2.3.4/jquery.wijmo-open.all.2.3.4.min.js" type="text/javascript"></script>

<script src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
<script src="${ctx}/static/operamasks/operamasks-ui.min.js" type="text/javascript"></script>
<sitemesh:head/>
</head>

<body>
	<div class="pageLayout">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div class="contentLayout" >
			<sitemesh:body/>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
</body>
</html>