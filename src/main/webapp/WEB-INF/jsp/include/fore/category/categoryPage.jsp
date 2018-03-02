
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<title>网上影楼-${c.name}</title>
<div id="category">
	<div class="categoryPageDiv">
		<%--显示当前分类名称--%>
		<%--<img src="img/category/${c.id}.jpg">--%>
		<a style="font-size: 15px;margin-left: 25px;color: #167C80;font-weight: bold;">${c.name}</a>
		<%--排序条--%>
		<%@include file="sortBar.jsp"%>
		<%--显示当前分类下的所有套餐--%>
		<%@include file="productsByCategory.jsp"%>
	</div>

</div>