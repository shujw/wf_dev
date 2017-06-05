<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.lang.reflect.Method"%>
<%@ page import="java.util.Map"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="jp.co.intra_mart.foundation.context.Contexts"%>
<%@ page import="jp.co.intra_mart.foundation.context.model.Context"%>
<%@ page import="jp.co.intra_mart.foundation.context.model.AccountContext"%>
<%@ page import="jp.co.intra_mart.system.context.model.ContextBase"%>

<%!

private static String toString(String[] array) {
	if (array == null) return "null";
	boolean first = true;
	StringBuilder string = new StringBuilder();
	for (String v : array) {
		if (first) first = false;
		else string.append(", ");
		string.append(v);
	}
	return string.toString();
}

private AccountContext getAccountContext() {
	return Contexts.get(AccountContext.class);
}

public static final <T> T invoke(Class<?> c, Object o, String methodName) {
	T result = null;
	try {
		Method m = c.getDeclaredMethod(methodName);
		m.setAccessible(true);
		result = (T) m.invoke(o);
	} catch (Exception e) {
		System.out.println("invoke error: " + methodName + ": " + e.toString());
	}
	return result;
}

private final Map<String, Object> getAttributes(HttpSession session) {
	String contextType = this.getAccountContext().getType().getName();
	AccountContext sessionContext = (AccountContext) session.getAttribute(contextType);
	return invoke(ContextBase.class, sessionContext, "getAttributes");
}
%>

		<script type="text/javascript">
			function showContext() {
				window.open("/imart/context.conf.context-show_context.service", "context_info", "width=800, height=640, scrollbars=yes, resizable=yes");
			}
		</script>

	<!-- タイトルバー -->
<section>
	<header class="imui-title">
		<h1>アカウントコンテキスト表示サンプル</h1>
	</header>

	<br>
	<article style="width:80%; margin:auto">

	<div class="imui-chapter-title mt-20"><h2>コード</h2></div>
	<div class="imui-list-tabPanel">

<div class="code"><pre>

  <span class="kd">public</span> <span class="kt">void</span> <span class="nf">init</span><span class="o">(</span><span class="o">)</span> <span class="o">{</span>
    accountContext <span class="o">=</span> <span class="kd">Contexts</span>.get<span class="o">(</span>AccountContext.<span class="kd">class</span><span class="o">)</span><span class="o">;</span>
  <span class="o">}</span>

</pre></div>

	</div>

	<div class="imui-chapter-title mt-20"><h2>AccountContext</h2></div>
		<table class="imui-table mt-20">
			<tr>
				<th class="wd-20">テナントID</th>
				<td class="bottom"><%= this.getAccountContext().getTenantId() %></td>
			</tr>
			<tr>
				<th class="wd-20">ログイングループID</th>
				<td class="bottom"><%= this.getAccountContext().getLoginGroupId() %></td>
			</tr>
			<tr>
				<th class="wd-20">ユーザ種別</th>
				<td class="bottom"><%= this.getAccountContext().getUserType() %></td>
			</tr>
			<tr>
				<th class="wd-20">ユーザID</th>
				<td class="bottom"><%= this.getAccountContext().getUserCd() %></td>
			</tr>
			<tr>
				<th class="wd-20">認証状況</th>
				<td class="bottom"><%= this.getAccountContext().isAuthenticated() %></td>
			</tr>
			<tr>
				<th class="wd-20">デザインテーマ</th>
				<td class="bottom"><%= this.getAccountContext().getThemeId() %></td>
			</tr>
			<tr>
				<th class="wd-20">ロケール</th>
				<td class="bottom"><%= this.getAccountContext().getLocale() %></td>
			</tr>
			<tr>
				<th class="wd-20">エンコード</th>
				<td class="bottom"><%= this.getAccountContext().getEncoding() %></td>
			</tr>
			<tr>
				<th class="wd-20">カレンダーID</th>
				<td class="bottom"><%= this.getAccountContext().getCalendarId() %></td>
			</tr>
			<tr>
				<th class="wd-20">タイムゾーン</th>
				<td class="bottom"><%= this.getAccountContext().getTimeZone() %></td>
			</tr>
			<tr>
				<th class="wd-20">日時表示形式</th>
				<td class="bottom"><%= this.getAccountContext().getDateTimeFormats() %></td>
			</tr>
			<tr>
				<th class="wd-20">週の開始曜日</th>
				<td class="bottom"><%= this.getAccountContext().getFirstDayOfWeek() %></td>
			</tr>
			<tr>
				<th class="wd-20">ログイン時間</th>
				<td class="bottom"><%= this.getAccountContext().getLoginTime() %></td>
			</tr>
			<tr>
				<th class="wd-20">署名</th>
				<td class="bottom"><%= this.getAccountContext().getSignature() %></td>
			</tr>
			<tr>
				<th class="wd-20">ホームページURL</th>
				<td class="bottom"><%= this.getAccountContext().getHomeUrl() %></td>
			</tr>
			<tr>
				<th class="wd-20">ロール</th>
				<td class="bottom"><%= this.getAccountContext().getRoleIds() %></td>
			</tr>
			<tr>
				<th class="wd-20">アプリケーションライセンス</th>
				<td class="bottom"><%= this.getAccountContext().getApplicationLicenses() %></td>
			</tr>
		    <tr>
				<th class="wd-20">数値形式のフォーマットID</th>
				<td class="bottom"><%= this.getAccountContext().getDecimalFormatId() %></td>
			</tr>
			
<%
	// プロパティを表示情報に変換
	Map<String, Object> attributes = getAttributes(session);
	if (attributes != null && !attributes.isEmpty()) {
%>
		<tr>
			<td class="list_data_bg_left" style="background-color: #ffffe2;" colspan="2">
				<div class="imui-chapter-title mt-20"><h2 class="mlc-module-title"></h2>Attributes</div>
				<table width="90%" class="imui-table mt-20">
					<tr>
						<th class="wd-20">Key</th>
						<th class="wd-20">Value</th>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<%
						int i = 0;
						for (Map.Entry<String, Object> attribute : attributes.entrySet()) {
					%>
					<tr>
						<td><%= attribute.getKey() %></td>
						<td><%= String.valueOf(attribute.getValue()) %></td>
					</tr>
					<% } // for (Map.Entry<String, Object> attribute : attributes.entrySet()) { %>

				</table>
			</td>
		</tr>

<%
	} // if (attributes != null && !attributes.isEmpty()) {
%>
		</table>
	</article>
</section>
