
<!DOCTYPE html>
<!-- 让浏览器以UTF显示中文，本页面的中文文字采用UTF-8编码，启动EL表达式  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"  import="java.util.*" %>
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
    <!-- 引入自定义的前端样式  -->
    <link href="css/fore/style.css" rel="stylesheet">

	<script>
        //公共js函数
        //以千进制格式化金额，比如金额是123456,就会显示成123,456
        function formatMoney(num){
            num = num.toString().replace(/\$|\,/g,'');
            if(isNaN(num))
                num = "0";
            sign = (num == (num = Math.abs(num)));
            num = Math.floor(num*100+0.50000000001);
            cents = num%100;
            num = Math.floor(num/100).toString();
            if(cents<10)
                cents = "0" + cents;
            for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
                num = num.substring(0,num.length-(4*i+3))+','+
                    num.substring(num.length-(4*i+3));
            return (((sign)?'':'-') + num + '.' + cents);
        }
        function checkEmpty(id, name){
            var value = $("#"+id).val();
            if(value.length==0){

                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }


        $(function(){


            $("a.productDetailTopReviewLink").click(function(){
                $("div.productReviewDiv").show();
                $("div.productDetailDiv").hide();
            });
            $("a.productReviewTopPartSelectedLink").click(function(){
                $("div.productReviewDiv").hide();
                $("div.productDetailDiv").show();
            });

            $("span.leaveMessageTextareaSpan").hide();
            $("img.leaveMessageImg").click(function(){

                $(this).hide();
                $("span.leaveMessageTextareaSpan").show();
                $("div.orderItemSumDiv").css("height","100px");
            });

            $("div#footer a[href$=#nowhere]").click(function(){
                alert("页脚的跳转链接");
            });



        });

	</script>
</head>

<body style="background:#EEF6F4;" class="backgroundImage">

