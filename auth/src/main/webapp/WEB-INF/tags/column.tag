<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%@tag pageEncoding="UTF-8"%>
<!-- id -->
<%@ attribute name="id"  required="true" description="id"%>
<!-- ajax取数方式对应的url地址 -->
<%@ attribute name="url"  required="true" description="url地址"%>
<!-- 表格高度，单位为px,也可以设为'fit'，表示自适应父容器高度。默认fit -->
<%@ attribute name="height"  required="false" description="高度"%>
<!-- 表格宽度，单位为px,也可以设为'fit'，表示自适应父容器宽度。默认100% -->
<%@ attribute name="width"  required="false" description="宽度" %>
<!-- 每页数据条数，比如每页要显示10条则设成10。注意：如果设成0或负数则不分页
	此属性仅用于取数不用于显示,
	即如果limit设成10，取数时告诉后台要10条数据，如果后台非要返回15条数据，
	则页面会显示出15条而不是10条数据）,默认15条 -->
<%@ attribute name="pagesize" required="false" description="每页数据条数" %>
<!-- 是否在最左边显示序号列。默认false -->
<%@ attribute name="showIndex"  required="false" description="是否显示序号列"%>
<!-- 是否自动拉伸各列以适应表格的宽度
（比如共2列第一列宽度100第二列宽度200，
则当表格总宽度是600px时第一列自动会变成200px第二列宽度会自动变成400px
，而如果表格总宽度是210px时第一列自动会变成70px第二列宽度会自动变成140px）
。注意：只有所有列的宽度都不是'autoExpand'时该属性才会起作用。默认false -->
<%@ attribute name="autoFit"  required="false" description="是否自动拉伸列宽度"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%
	

	if(StringUtils.isEmpty(height)) {
		height = "fit";
	}
	if("fit".equals(height)) {
		height = "'" + height + "'";
	}
	if(StringUtils.isEmpty(width)) {
		width = "fit";
	}
	if("fit".equals(width)) {
		width = "'" + width + "'";
	}
	if(StringUtils.isEmpty(pagesize)) {
		pagesize = "15";
	}
	if(StringUtils.isEmpty(showIndex)) {
		showIndex = "false";
	}
	if(StringUtils.isEmpty(autoFit)) {
		autoFit = "false";
	}
%>


<script type="text/javascript">

	jQuery(document).ready(function() {
		jQuery('#${id}').omGrid({
	        title : '',
	        dataSource : '${ctx}${url}',
	        height :  <%=height%>,
	        width :  <%=width%>,
	        limit : <%=pagesize%>,
	        showIndex : <%=showIndex%>,
	        autoFit : <%=autoFit%>,
	        colModel : [ {header : '类型代码', name : 'typeCode', width : 100, align : 'center'}, 
	                     {header : '类型名称', name : 'typeName', width : 120, align : 'left'}, 
	                     {header : '从属的组别', name : 'groupName', align : 'left', width : 'autoExpand'} ]
	    });
	});
</script>

<table id="${id}"></table>
