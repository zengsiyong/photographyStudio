
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<div class="payedDiv">
	<div class="payedTextDiv">
		<img src="img/site/paySuccess.png">
		<span>您已成功付款</span> 
		
	</div>
	<div class="payedAddressInfo">
		<ul>
			<%--<li>收货地址：${o.address} ${o.receiver} ${o.mobile }</li>--%>
			<li>实付款：<span class="payedInfoPrice">
			￥<fmt:formatNumber type="number" value="${param.total}" minFractionDigits="2"/>
			</li>
			<li>感谢您的支持，期待下一次为您提供更加完美的服务	</li>
		</ul>
				
		<div class="paedCheckLinkDiv">
			您可以
			<a class="payedCheckLink" href="forebought">查看已买到的摄影套餐</a>
			<a class="payedCheckLink" href="forebought">查看交易详情 </a>
		</div>
			
	</div>
	
	<div class="payedSeperateLine">
	</div>
	
	<div class="warningDiv">
		<img src="img/site/warning.png">
		<b>安全提醒：</b>下单后，<span class="redColor boldWord">用QQ或微信给您发送链接办理退款的都是骗子！</span>本网上影楼不存在系统升级，订单异常等问题，谨防假冒客服电话诈骗！
	</div>

	

</div>