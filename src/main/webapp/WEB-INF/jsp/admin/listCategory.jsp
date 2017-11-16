<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<%-- 该函数用于判断提交新的分类页面中如果有空白项，则新增分类失败--%>
<script>
	$(function(){

		$("#addForm").submit(function(){
			if(!checkEmpty("name","分类名称"))
				return false;
			if(!checkEmpty("categoryPic","分类图片"))
				return false;
			return true;
		});
	});

</script>

<title>分类管理</title>

<div class="workingArea">
	<%-- 框架的颜色标签样式 --%>
	<h3 class="label label-success" >分类管理</h3>
	<br>
	<br>

	<div class="listDataTableDiv">
		<%-- bootstrap的table样式，包括斑马线效果--%>
		<table class="table table-striped  table-hover  table-condensed ">
			<thead>
			<tr class="success">
				<th>ID</th>
				<th>图片</th>
				<th>分类名称</th>
				<th>属性管理</th>
				<th>产品管理</th>
				<th>编辑</th>
				<th>删除</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${cs}" var="c">

				<tr>
					<td>${c.id}</td>
					<td><img height="40px" src="img/category/${c.id}.jpg"></td>
					<td>${c.name}</td>

					<td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon glyphicon-tasks"></span></a></td>
					<td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>
					<td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
					<%--用于删除的超链，指向地址admin_category_delete,并且会传递当前分类对象的id过去。--%>
					<td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="   glyphicon glyphicon-trash"></span></a></td>


				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>




	<%-- 分页功能页面选择部分 --%>
	<div class="pageDiv">
		<%@include file="../include/admin/adminPage.jsp" %>
	</div>


	<%-- 运用了bootstrap的panel面板 addDiv是单独地设置长度css--%>
	<div class="panel panel-success addDiv">
		<div class="panel-heading">新增分类</div>
		<div class="panel-body">
			<%-- 在包含上传文件的表单中必须有属性 enctype="multipart/form-data"--%>
			<form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
				<table class="addTable">
					<tr>
						<td>分类名称</td>
						<td><input  id="name" name="name" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>分类图片</td>
						<td>
							<input id="categoryPic" accept="image/*" type="file" name="image" />
						</td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</div>

<%@include file="../include/admin/adminFooter.jsp"%>