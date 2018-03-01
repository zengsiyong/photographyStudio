
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<title> 网上影楼</title>
<%--<div class="categoryPictureInProductPageDiv">--%>
	<%--<img class="categoryPictureInProductPage" src="img/category/${p.category.id}.jpg">--%>
<%--</div>--%>

<div class="productPageDiv" style="margin-top: -40px;">

	<%@include file="imgAndInfo.jsp" %>

	<%@include file="productReview.jsp" %>

	<%@include file="productDetail.jsp" %>
</div>