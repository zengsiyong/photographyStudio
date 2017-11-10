<!-- 模仿天猫整站j2ee 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navitagorDiv">
	<%--&lt;%&ndash;创建一个默认的导航栏的步骤如下：向 <nav> 标签添加 class .navbar、.navbar-default&ndash;%&gt;--%>
	<%--<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">--%>
		<%--&lt;%&ndash;先将ContextPath,即输出为项目根目录，即WebRoot，放如page域对象中，再使用el表达式取出&ndash;%&gt;--%>
		<%--<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>--%>
		<%--<img style="margin-left:10px;margin-right:10px" class="pull-left" src="${path}/img/site/sitelogo.jpg" height="50px">--%>
		<%--<a class="navbar-brand" href="#nowhere">影楼后台</a>--%>
		<%----%>
		<%--<a class="navbar-brand" href="admin_category_list">分类管理</a>--%>
		<%--<a class="navbar-brand" href="admin_user_list">用户管理</a>--%>
		<%--<a class="navbar-brand" href="admin_order_list">订单管理</a>--%>
	<%--</nav>--%>


		<%-- 使用bootstrap的navbar导航栏样式--%>
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<%--先将ContextPath,即输出为项目根目录，即WebRoot，放如page域对象中，再使用el表达式取出--%>
				<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
				<img style="margin-left:0px;margin-right:15px" class="pull-left" src="${path}/img/site/sitelogo.jpg" height="50px">
				<div>
					<ul class="nav navbar-nav">
						<li><a class="navbar-brand" href="#nowhere">影楼后台</a></li>
						<li><a class="navbar-brand" href="admin_category_list">分类管理</a></li>
						<li><a class="navbar-brand" href="admin_user_list">用户管理</a></li>
						<li><a class="navbar-brand" href="admin_order_list">订单管理</a></li>
					</ul>
				</div>
			</div>
		</nav>
</div>