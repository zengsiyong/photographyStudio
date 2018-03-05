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

	<script>
		$(function(){
//		这段代码用于当账号提交到服务端，服务端判断当前账号已经存在的情况下，显示返回的错误提示 "用户名已经被使用,不能使用"
			<c:if test="${!empty msg}">
			$("span.errorMessage").html("${msg}");
			$("div.registerErrorMessageDiv").css("visibility","visible");
			</c:if>
//		表单按钮提交注册信息时，进行为空判断，弹出错误信息
			$(".registerForm").submit(function(){
				if(0==$("#name").val().length){
					$("span.errorMessage").html("请输入用户名");
					$("div.registerErrorMessageDiv").css("visibility","visible");
					return false;
				}
				if(0==$("#password").val().length){
					$("span.errorMessage").html("请输入密码");
					$("div.registerErrorMessageDiv").css("visibility","visible");
					return false;
				}
				if(0==$("#repeatpassword").val().length){
					$("span.errorMessage").html("请输入重复密码");
					$("div.registerErrorMessageDiv").css("visibility","visible");
					return false;
				}
				if($("#password").val() !=$("#repeatpassword").val()){
					$("span.errorMessage").html("重复密码不一致");
					$("div.registerErrorMessageDiv").css("visibility","visible");
					return false;
				}

				return true;
			});
		})
	</script>
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

<div style="position: relative">
	<div  class="registerSmallDiv" style="margin-left: 40%;margin-top:60px">
		<form method="post" action="foreregister" class="registerForm">
			<div class="registerDiv">
				<div class="registerErrorMessageDiv">
					<div class="alert alert-danger" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
						<span class="errorMessage"></span>
					</div>
				</div>


				<table class="registerTable" align="center">
					<tr>
						<td  class="registerTip registerTableLeftTD">设置会员名</td>
						<td></td>
					</tr>
					<tr>
						<td class="registerTableLeftTD">登陆名</td>
						<td  class="registerTableRightTD"><input id="name" name="name" placeholder="会员名不超过25字" > </td>
					</tr>
					<tr>
						<td  class="registerTip registerTableLeftTD">设置登陆密码</td>
						<td  class="registerTableRightTD"></td>
					</tr>
					<tr>
						<td class="registerTableLeftTD">登陆密码</td>
						<td class="registerTableRightTD"><input id="password" name="password" type="password"  placeholder="设置你的登陆密码" > </td>
					</tr>
					<tr>
						<td class="registerTableLeftTD">密码确认</td>
						<td class="registerTableRightTD"><input id="repeatpassword" type="password"   placeholder="请再次输入你的密码" > </td>
					</tr>

					<tr>
						<td colspan="4" class="registerButtonTD">
							<a href="registerSuccess.jsp"><button>注   册</button></a>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>

</div>


</body>


</html>