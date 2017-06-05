<%--
 - ポートレットイベントサンプル
 - 「イベント」受信結果を表示する
 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="jp.co.intra_mart.foundation.portal.common.PortalManager" %>
<%
// RenderRequestの取得
RenderRequest pReq = PortalManager.getRenderRequest();

// RenderParameterを利用する
String message = "";
if(pReq.getParameter("javaSendMsg") != null){
	message = pReq.getParameter("javaSendMsg");
}
%>
<h3 style="color:#000; border-bottom: 1px solid green;">JavaEE Framework Portlet <br> 【イベント受信１】</h3>
<p align="center" style="font-size:16pt; font-weight:bold; color:#63CC47">
	<%= message %>
</p><br/>
