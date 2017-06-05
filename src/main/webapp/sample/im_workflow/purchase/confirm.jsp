<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="imartj2ee" uri="http://www.intra-mart.co.jp/taglib/core/framework" %>
<%@ taglib prefix="imui" uri="http://www.intra-mart.co.jp/taglib/imui" %>
<%@ taglib prefix="workflow" uri="http://www.intra-mart.co.jp/taglib/imw/workflow" %>
<imartj2ee:HelperBean id="bean" class="jp.co.intra_mart.sample.workflow.purchase.controller.view.CommonHelperBean"/>

<imui:head>
<title><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></title>

<workflow:workflowOpenPageCsjs />
<script type="text/javascript">
$(function(){
	$('#back').click(function(){
		$('#backForm').submit();
		return false;
    });
	$('#openPage').click(function(){
		workflowOpenPage('<%=(String)request.getAttribute("imwPageType")%>');
		return false;
    });
});
</script>
</imui:head>

<workflow:workflowOpenPage name="workflowOpenPageForm"
                              method="POST"
                              target="_top"
                              imwSystemMatterId='<%=(String)request.getAttribute("imwSystemMatterId")%>'
                              imwNodeId='<%=(String)request.getAttribute("imwNodeId")%>'
                              imwCallOriginalParams='<%=(String)request.getAttribute("imwCallOriginalParams")%>'
                              imwNextScriptPath='<%=(String)request.getAttribute("imwCallOriginalPagePath")%>' />

<div class="imui-title-small-window">
	<h1><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></h1>
</div>
<div class="imui-toolbar-wrap">
 	<div class="imui-toolbar-inner">
		<ul class="imui-list-toolbar">
			<li>
				<a href="javascript:void(0);" id="back">
					<span class="im-ui-icon-common-16-back"></span>
				</a>
			</li>
		</ul>
	</div>
</div>

<div class="imui-form-container">
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

	<div class="imui-operation-parts">
		<imui:button value='<%=bean.getMessage("SAMPLE.IMW.CAP.006")%>' id="openPage" name="openPage" class="imui-large-button" escapeXml="true" escapeJs="false" />
	</div>
</div>

<form name="backForm" id="backForm" method="POST" action='<%=(String)request.getAttribute("imwCallOriginalPagePath")%>'>
    <input type="hidden" name=imwCallOriginalParams value='<%=(String)request.getAttribute("imwCallOriginalParams")%>' />
</form>
