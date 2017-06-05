<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="jp.co.intra_mart.foundation.context.Contexts"%>
<%@ page import="jp.co.intra_mart.foundation.user_context.model.UserContext"%>
<%@ page import="jp.co.intra_mart.foundation.user_context.model.*"%>
<%@ page import="jp.co.intra_mart.system.user_context.web.LazyUserContext"%>

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

private UserContext getUserContext() {
	UserContext context = Contexts.get(UserContext.class);
	if (context instanceof LazyUserContext)
		context = ((LazyUserContext) context).getInternal();
	return context;
}

private String getCurrentDepartmentBizKey() {
	Department bizKey = getUserContext().getCurrentDepartment();
	if (bizKey != null) {
		return bizKey.getCompanyCd() + "-" + bizKey.getDepartmentSetCd() + "-" + bizKey.getDepartmentCd();
	}
	return null;
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
		<h1>ユーザコンテキスト表示サンプル</h1>
	</header>

	<br>
	<article style="width:80%; margin:auto">

	<div class="imui-chapter-title mt-20"><h2>コード</h2></div>
	<div class="imui-list-tabPanel">

<div class="code"><pre>

  <span class="kd">public</span> <span class="kt">void</span> <span class="nf">init</span><span class="o">(</span><span class="o">)</span> <span class="o">{</span>
    userContext <span class="o">=</span> <span class="kd">Contexts</span>.get<span class="o">(</span>UserContext.<span class="kd">class</span><span class="o">)</span><span class="o">;</span>
  <span class="o">}</span>

</pre></div>

	</div>

	<div class="imui-chapter-title mt-20"><h2>UserContext</h2></div>
		<table class="imui-table mt-20">
			<tr>
				<td class="bottom">カレント組織コード</td>
				<td class="bottom"><%= getCurrentDepartmentBizKey() %></td>
			</tr>
			<tr>
				<td class="bottom">ユーザプロファイル情報</td>
				<td class="bottom"><%= this.getUserContext().getUserProfile() %></td>
			</tr>
			<tr>
				<td class="bottom">ユーザの会社所属情報</td>
				<td class="bottom"><%= this.getUserContext().getCompanyList() %></td>
			</tr>
			<tr>
				<td class="bottom">会社別の組織所属情報</td>
				<td class="bottom"><%= this.getUserContext().getDepartmentByCompany() %></td>
			</tr>
			<tr>
				<td class="bottom">組織所属情報</td>
				<td class="bottom"><%= this.getUserContext().getMainDepartment() %></td>
			</tr>
			<tr>
				<td class="bottom">パブリックグループ所属情報</td>
				<td class="bottom"><%= this.getUserContext().getPublicGroupList() %></td>
			</tr>
			<tr>
				<td class="bottom">ユーザ分類情報</td>
				<td class="bottom"><%= this.getUserContext().getUserCategoryList() %></td>
			</tr>
		</table>
	</article>
</section>
