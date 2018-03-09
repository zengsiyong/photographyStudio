
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

			<c:if test="${!empty msg}">
			$("span.errorMessage").html("${msg}");
			$("div.loginErrorMessageDiv").show();
			</c:if>

			$("form.loginForm").submit(function(){
				if(0==$("#name").val().length||0==$("#password").val().length){
					$("span.errorMessage").html("请输入账号密码");
					$("div.loginErrorMessageDiv").show();
					return false;
				}
				return true;
			});

			$("form.loginForm input").keyup(function(){
				$("div.loginErrorMessageDiv").hide();
			});


			var left = window.innerWidth/2+162;
			$("div.loginSmallDiv").css("left",left);
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

	<div id="loginDiv" style="position: relative">

		<form class="loginForm" action="forelogin" method="post">
			<div id="loginSmallDiv" class="loginSmallDiv" style="margin-left: 40%;margin-top: 60px;">
				<div class="loginErrorMessageDiv">
					<div class="alert alert-danger" >
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
						<span class="errorMessage"></span>
					</div>
				</div>

				<div class="login_acount_text">账户登录</div>
				<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-user"></span>
				</span>
					<input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">
				</div>

				<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-lock"></span>
				</span>
					<input id="password" name="password" type="password" placeholder="密码" type="text">
				</div>
				<span class="text-danger"></span><br><br>


				<div>
					<a class="notImplementLink" href="#nowhere">忘记登录密码</a>
					<a href="registerPage" class="pull-right">免费注册</a>
				</div>
				<div style="margin-top:20px">
					<button class="btn btn-block redButton" type="submit">登录</button>
				</div>
			</div>
		</form>


	</div>
</body>


</html>