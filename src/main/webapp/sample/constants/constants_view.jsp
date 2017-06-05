<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="jp.co.intra_mart.foundation.admin.validdate.SystemValidDate"%>
<%@ page import="jp.co.intra_mart.system.admin.constants.TenantConstantsMap"%>
<%@ page import="jp.co.intra_mart.system.admin.constants.SystemConstantsMap"%>
<%@ page import="jp.co.intra_mart.system.admin.constants.AdministratorConstantsMap"%>

<!--
		<link rel="stylesheet" type="text/css" href="/imart/v8/sample/css/code.css"/>
-->
		<script type="text/javascript">
		</script>

	<!-- タイトルバー -->
<section>
	<header class="imui-title">
		<h1>システム最大最小日、および システム・テナント管理者・テナント定数 表示サンプル</h1>
	</header>

	<br>
	<article style="width:80%; margin:auto">

	<br />

	<div class="imui-chapter-title mt-20"><h2>システム最大最小日</h2></div>
	<table class="imui-table mt-20">
		<tr>
			<th class="wd-20">システム最小日</th>
			<td class="bottom"><%= SystemValidDate.getMinDate() %></td>
		</tr>
		<tr>
			<th class="wd-20">システム最大日</th>
			<td class="bottom"><%= SystemValidDate.getMaxDate() %></td>
		</tr>
	</table>
	<div class="imui-chapter-title mt-20"><h2>コード</h2></div>
	<div class="imui-list-tabPanel">

	<div class="code"><pre>
	SystemValidDate.getMinDate();
	SystemValidDate.getMaxDate();
	</pre>
	</div>

	</div>
	
	</article>
</section>
