<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="imtag" uri="http://www.intra-mart.co.jp/taglib/core/standard" %>
<%@ taglib prefix="imartj2ee" uri="http://www.intra-mart.co.jp/taglib/core/framework" %>
<%@ taglib prefix="imui" uri="http://www.intra-mart.co.jp/taglib/imui" %>
<%@ taglib prefix="workflow" uri="http://www.intra-mart.co.jp/taglib/imw/workflow" %>
<imartj2ee:HelperBean id="bean" class="jp.co.intra_mart.sample.workflow.purchase.controller.view.CommonHelperBean"/>
<%@ page import="jp.co.intra_mart.foundation.multi_device.client_type.ClientTypeSwitcher" %>
<%
ClientTypeSwitcher.oneTimeSwitchTo("pc");
%>
<imui:head>
<title><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></title>
<link rel="stylesheet" href="im_workflow/css/im_workflow.css" type="text/css" />

<workflow:workflowOpenPageCsjs />
<script type="text/javascript">
$(function(){
	$('#close').click(function(){
		window.close();
		return false;
	});
});
</script>
</imui:head>

<body style="min-width:0px">
	<div class="imui-title-small-window">
		<h1 style="min-width:0px;"><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></h1>
	</div>
	<div id="imui-container" style="min-width:0px; min-height:0px;">
	 	<div class="imui-toolbar-wrap">
			<div class="imui-toolbar-inner" style="min-width:0px;">
				<ul class="imui-list-toolbar">
					<li>
						<workflow:workflowMatterDetailLink systemMatterId='<%=(String)request.getAttribute("imwSystemMatterId")%>'>
							<span class="im-workflow-icon-matter-detail mr-5"></span><%=bean.getMessage("SAMPLE.IMW.CAP.007")%>
						</workflow:workflowMatterDetailLink>
					</li>
				</ul>
				<imtag:condition validity='<%= ("1".equals((String)request.getAttribute("imwShortCutFlag"))) ? "true" : "false" %>' negative="true">
				<ul class="imui-list-toolbar-utility">
					<li>
						<a href="javascript:void(0);" id="close">
							<span class="im-ui-icon-common-16-close mr-5"></span>
						</a>
					</li>
				</ul>
				</imtag:condition>
			</div>
		</div>
	</div>
	<div class="imui-form-container mt-20">
		<header class="imui-chapter-title">
			<h2><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></h2>
		</header>

		<table class="imui-form">
			<tbody>
				<tr>
					<th><label><%=bean.getMessage("SAMPLE.IMW.CAP.020")%></label></th>
					<td><p><%=(String)request.getAttribute("item_name")%></p></td>
				</tr>
				<tr>
					<th><label><%=bean.getMessage("SAMPLE.IMW.CAP.021")%></label></th>
					<td><p><%=(String)request.getAttribute("item_amount")%></p></td>
				</tr>
				<tr>
					<th><label><%=bean.getMessage("SAMPLE.IMW.CAP.022")%></label></th>
					<td><p><%=(String)request.getAttribute("item_price")%></p></td>
				</tr>
				<tr>
					<th><label><%=bean.getMessage("SAMPLE.IMW.CAP.023")%></label></th>
					<td><p><%=(String)request.getAttribute("item_total")%></p></td>
				</tr>
				<tr>
					<th><label><%=bean.getMessage("SAMPLE.IMW.CAP.024")%></label></th>
					<td>
						<textarea id="notes" name="item_comment" rows="3" cols="40" readonly=true><%=(String)request.getAttribute("item_comment")%></textarea>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>

