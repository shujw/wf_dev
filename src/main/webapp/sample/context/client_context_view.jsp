<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/j2ee/document/error/error.jsp"%>

<%@ page import="jp.co.intra_mart.foundation.context.Contexts"%>
<%@ page import="jp.co.intra_mart.foundation.context.model.ClientContext"%>

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

private ClientContext getClientContext() {
	return Contexts.get(ClientContext.class);
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
		<h1>クライアントコンテキスト表示サンプル</h1>
	</header>

	<br>
	<article style="width:80%; margin:auto">

	<div class="imui-chapter-title mt-20"><h2>コード</h2></div>
	<div class="imui-list-tabPanel">

<div class="code"><pre>

  <span class="kd">public</span> <span class="kt">void</span> <span class="nf">init</span><span class="o">(</span><span class="o">)</span> <span class="o">{</span>
    clientContext <span class="o">=</span> <span class="kd">Contexts</span>.get<span class="o">(</span>ClientContext.<span class="kd">class</span><span class="o">)</span><span class="o">;</span>
  <span class="o">}</span>

</pre></div>

	</div>

  <br>
	<div class="imui-chapter-title mt-20"><h2>ClientContext</h2></div>
		<table class="imui-table mt-20">
					<tr>
						<th class="wd-20">クライアントタイプID</th>
						<td class="bottom"><%= this.getClientContext().getClientTypeId() %></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</article>
</section>
