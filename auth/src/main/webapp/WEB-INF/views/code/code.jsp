<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="j" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ja" uri="/journeyAuthtaglib" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<!--Journey default css-->
<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<!--zTree default css-->
<link href="${ctx}/static/styles/ztree/ztree.css" type="text/css" rel="stylesheet" />
<!--operamask default Theme-->
<link href="${ctx}/static/styles/operamasks/elegant/om-elegant.css" type="text/css" rel="stylesheet" />

<script src="${ctx}/static/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/static/operamasks/operamasks-ui.min.js" type="text/javascript"></script>
<script src="${ctx}/static/ztree/3.5/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
<script src="${ctx}/static/auth/1.0/code/code.js" type="text/javascript"></script>
<script src="${ctx}/static/auth/1.0/jbase.js" type="text/javascript"></script>
<script type="text/javascript">
var ctx = '${ctx}' ;
</script>
</head>
<body class="bodyDefaultSize">

<div id='d_pageLayout'  >
	<div id='d_query' >
		<ul id="codeTypeTree" class="ztree"></ul>
	</div>
	<div id='d_detail' >
		<table id="codeList"></table>
		<div id="editButtonBar1"></div>
		<div id="editButtonBar2" class="invisible"></div>
	</div>
	
	<!-- 对话框 -->
	<div id='layer1EditDialog' class="invisible">
	<form id="layer1Editform" >
	<table>
		<tr>
			<td>
				<label class="lableWidth1">码表类型:</label>
			</td>
			<td>
				<input name="typeName" type="text" class="inputWidth1">
			</td>
		</tr>
		<tr>
			<td>
				<label class="lableWidth1">码表代码:</label>
			</td>
			<td>
				<input name="typeCode" type="text" class="inputWidth1">
			</td>
		</tr>
		<tr id="td_groupName" class="invisible">
			<td>
				<label class="lableWidth1">上级码表类型:</label>
			</td>
			<td>
				<input name="groupName" readonly="readonly" type="text" class="inputWidth1">
			</td>
		</tr>
		<tr>
			<td>
				<label class="lableWidth1">备注:</label>
			</td>
			<td>
				<textarea name="remark" rows="3" cols="18"  class='disResizable inputWidth1' ></textarea>
			</td>
		</tr>
	</table>
	<input name="id" type="hidden" >
	</form>
	</div>
</div>
</body>
</html>