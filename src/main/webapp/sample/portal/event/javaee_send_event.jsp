<%--
 - ポートレットイベントサンプル
 - 「アクション」を呼び出す
 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.Vector" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="jp.co.intra_mart.foundation.portal.common.PortalManager" %>

<%@ taglib prefix="imart" uri="http://www.intra-mart.co.jp/taglib/core/standard" %>

<%!
// イベントキーリスト
private static Vector list = new Vector();
static {
	String[] eventKeys = new String[]{"framework", "pagebase", "all", "event1", "event2"};
	String[] eventTexts = new String[]{"JavaEEに送信", "Presentationに送信", "全てに送信", "ポートレット１に送信", "ポートレット２に送信"};
	for (int i=0; i<eventKeys.length; i++) {
		Hashtable ht = new Hashtable();
		ht.put("value", eventKeys[i]);
		ht.put("text", eventTexts[i]);
		list.add(ht);
	}
}
%>

<%
// RenderRequestの取得
RenderRequest pReq = PortalManager.getRenderRequest();

// ActionURLの取得
PortletURL actionURL = PortalManager.createActionURL();

// RenderParameterを利用する
Vector selectedList = null;
if(pReq.getParameter("event_id") != null){
	selectedList = new Vector();
	String eventId = pReq.getParameter("event_id");
	selectedList.add(eventId);
}

String message = "";
if(pReq.getParameter("message") != null){
	message = pReq.getParameter("message");
}
%>

<h3 style="color:#000; border-bottom: 1px solid green;">JavaEE Framework Portlet <br> 【イベント送信】</h3>

<%-- 送信先にActionURLを設定する --%>
<form name="javaeeEventForm" method="POST" action="<%= actionURL.toString() %>">
	送信先：<imart:select list="<%= list %>" name="event_id" selected="<%= selectedList %>"
		option_value="value" option_text="text" /><br><br>
	メッセージ：<input type="text" name="message" value="<%= message %>"/><br><br>
	<input type="submit" name="publish" value="送信"/>
</form>
