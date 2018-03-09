<!DOCTYPE html>
<!-- 让浏览器以UTF显示中文，本页面的中文文字采用UTF-8编码，启动EL表达式  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<!-- 引入标准标签库  -->
<!-- c通常用于条件判断和遍历  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- fmt用于格式化日期和货币  -->
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- fn用于校验长度  -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
	<!-- 引入bootstrap和jquery  -->
	<script src="js/jquery/2.0.0/jquery.min.js"></script>
	<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">

	<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>

	<!-- 引入登入注册页所需的css样式  -->
	<link rel="stylesheet" type="text/css" href="css/fore/loginPage/styles.css">
	<link rel="stylesheet" type="text/css" href="css/fore/style.css">


</head>

<body style="background:#EEF6F4;">
<%--头部--%>
<nav class="top ">
	<a href="${contextPath}">
		<span style="color:#1F375B;margin:0px" class=" glyphicon glyphicon-home redColor"></span>
		影楼首页
	</a>

	<span>为您提供最优质的摄影服务</span>

	<c:if test="${!empty user}">
		<a href="loginPage">${user.name}</a>
		<a href="forelogout">退出</a>
	</c:if>

	<c:if test="${empty user}">
		<a href="loginPage">请登录</a>
		<a href="registerPage">免费注册</a>
	</c:if>


		<span class="pull-right">
			<a href="forebought">我的订单</a>
			<a href="forecart">
				<span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-shopping-cart redColor"></span>
				购物车<strong>${cartTotalItemNumber}</strong>件</a>
		</span>
</nav>

<%--简单搜索框--%>
<div >
	<a href="${contextPath}">
		<img id="simpleLogo" class="simpleLogo" src="img/site/studioLogo.png">
	</a>

	<form action="foresearch" method="post" >
		<div class="simpleSearchDiv pull-right">
			<input type="text" placeholder="日系写真 婚庆"  value="${param.keyword}" name="keyword">
			<button class="searchButton" type="submit">搜种类</button>
			<div class="searchBelow">
				<c:forEach items="${cs}" var="c" varStatus="st">
					<c:if test="${st.count>=1 and st.count<=4}">
					<span>
						<a href="forecategory?cid=${c.id}">
								${c.name}
						</a>
						<c:if test="${st.count!=11}">
							<span>|</span>
						</c:if>
					</span>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</form>
	<div style="clear:both"></div>
</div>


<%--&lt;%&ndash;背景特效图片&ndash;%&gt;--%>
<div class="wrapper">
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>


</div>

<div class="registerSuccessDiv" style="width:180px;height:120px;margin:auto;position: relative;margin-top:150px">

	<div style="position:absolute;width:220px;height:100px;margin:auto;margin-left: -65px;margin-top:4px;    ">
		<img align="center" style="position: relative" src="img/site/registerSuccess.png">
		注册成功
		<br>
		<a id="loginHref" href="loginPage">点击进入登入界面</a>
	</div>

</div>

<script>
	//获取当前网址，如： http://localhost:80/ybzx/index.jsp
	var curPath=window.document.location.href;
	//获取主机地址之后的目录，如： /photo_ssm/registerSuccessPage
	var pathName=window.document.location.pathname;
	var pos=curPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8080
	var localhostPath=curPath.substring(0,pos);
	//获取带"/"的项目名，如：/photo_ssm
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	//获取 http://localhost:8080/photo_ssm
	var projectRootPath = localhostPath + projectName;

//	$(function(){
//		alert(pathName);
//		alert(pos);
//		alert(localhostPath);
//		alert(projectName);
//		alert(projectRootPath);
//
//	});
</script>
</body>


</html>