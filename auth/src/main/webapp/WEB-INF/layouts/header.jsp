<%@page import="java.util.List"%>
<%@page import="com.journey.base.auth.model.MenuGroup"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="ja" uri="/journeyAuthtaglib" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${ctx}/static/styles/simpleMenu/style.css" type="text/css" media="screen, projection"/>
<script type="text/javascript" src="${ctx}/static/simpleMenu/jquery.dropdownPlain.js"></script>
<script>
	function addAndShowSinaTab() {
		//增加标签lable
		var u = $("#mainTabs ul");
		var l = $("<li/>").appendTo(u);
		var a = $("<a href='#3' data-toggle='tab'>注册</a>").appendTo(l);
	
		//增加标签content
		var d = $("#mainTabs>div");
		var c = $("<div class='tab-pane' id='3' />").appendTo(d);
	
		$("<iframe id='iframe1' src='${ctx}/register' />").appendTo(c);
		//设置当前tab为active
		a.tab("show");
		//设置双击关闭tab事件
		a.bind("dblclick",closeTab);
	}
	
	function closeTab() {
		var frame = $('#iframe1');
		//避免IE内存泄露
		frame[0].contentWindow.document.write('');//清空iframe的内容
		frame[0].contentWindow.close();//避免iframe内存泄漏
		frame.remove();//删除iframe
		
		var content = $('#3');
		content.remove();
		var l = $('#mainTabs>ul>li:last');
		l.remove();
	}

</script>

<div id="header">
	<div class="pageTitle">
	    <h1><span>journey平台</span><small><span>--TodoList应用演示</span></small>
		</h1>
	</div>
	<ja:simpleMenu/>
	<div class="loginOut">
		<a href="${ctx}/auth/logout">注销</a>
	</div>
	<div class="fixf" > </div>
</div>