<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="imartj2ee" uri="http://www.intra-mart.co.jp/taglib/core/framework" %>
<%@ taglib prefix="imui" uri="http://www.intra-mart.co.jp/taglib/imui" %>
<%@ taglib prefix="imart" uri="http://www.intra-mart.co.jp/taglib/core/standard" %>
<%@ taglib prefix="workflow" uri="http://www.intra-mart.co.jp/taglib/imw/workflow" %>
<imartj2ee:HelperBean id="bean" class="jp.co.intra_mart.sample.workflow.purchase.controller.view.CommonHelperBean"/>

<imui:head>
<title><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></title>

<workflow:workflowOpenPageCsjs />
<script src="ui/libs/jquery-validation-1.9.0/jquery.validate.js"></script>
<script type="text/javascript">
var rules = {
	item_name : {
		required : true
	},
	item_amount : {
		required : true,
		number   : true
	},
	item_price : {
		required : true,
		number   : true
	}
};
var messages = {
		item_name : {
		required : '<%=bean.getMessage("SAMPLE.IMW.INF.000")%>'
	},
	item_amount : {
		required : '<%=bean.getMessage("SAMPLE.IMW.INF.001")%>',
		number   : '<%=bean.getMessage("SAMPLE.IMW.INF.003")%>'
	},
	item_price : {
		required : '<%=bean.getMessage("SAMPLE.IMW.INF.002")%>',
		number   : '<%=bean.getMessage("SAMPLE.IMW.INF.004")%>'
	}
};

function callbackFnc(result) {
	var msg = "Callback function is executed.";
	if (typeof result != 'undefined') {
		msg += "<br>" + "<br>";
		msg += "imwSystemMatterId : " + result.imwSystemMatterId;
		if (typeof result.imwUserDataId != 'undefined') {
			msg += "<br>";
			msg += "imwUserDataId     : " + result.imwUserDataId;
		}
		msg += "<br>" + "<br>";
		msg += "In 5 seconds, it changes to the next screen."
		imuiShowSuccessMessage(msg);
		setTimeout(function() {$('#backForm').submit();}, 5000);
	} else {
		imuiShowSuccessMessage(msg);
	}
}

$(function(){
	$('#back').click(function(){
		$('#backForm').submit();
		return false;
    });
	$('#openPage0').click(function(){
		if (!imuiValidate('#workflowOpenPageForm', rules, messages)) return;
		workflowOpenPage('0', callbackFnc);
		return false;
    });
	$('#openPage1').click(function(){
		workflowOpenPage('1', callbackFnc);
		return false;
    });
	$('#openPage2').click(function(){
		if (!imuiValidate('#workflowOpenPageForm', rules, messages)) return;
		workflowOpenPage('2', callbackFnc);
		return false;
    });
	$('#openPage3').click(function(){
		if (!imuiValidate('#workflowOpenPageForm', rules, messages)) return;
		workflowOpenPage('3', callbackFnc);
		return false;
    });
});
</script>
</imui:head>

<workflow:workflowOpenPage name="workflowOpenPageForm"
                           id="workflowOpenPageForm"
                           method="POST"
                           target="_top"
                           imwUserDataId='<%=(String)request.getAttribute("imwUserDataId")%>'
                           imwSystemMatterId='<%=(String)request.getAttribute("imwSystemMatterId")%>'
                           imwAuthUserCode='<%=(String)request.getAttribute("imwAuthUserCode")%>'
                           imwApplyBaseDate='<%=(String)request.getAttribute("imwApplyBaseDate")%>'
                           imwNodeId='<%=(String)request.getAttribute("imwNodeId")%>'
                           imwFlowId='<%=(String)request.getAttribute("imwFlowId")%>'
                           imwCallOriginalParams='<%=(String)request.getAttribute("imwCallOriginalParams")%>'>

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
					<th><label class="imui-required"><%=bean.getMessage("SAMPLE.IMW.CAP.020")%></label></th>
					<td><input type="text" value='<%=(String)request.getAttribute("item_name")%>' id="item_name" name="item_name" size="50"></td>
				</tr>
				<tr>
					<th><label class="imui-required"><%=bean.getMessage("SAMPLE.IMW.CAP.021")%></label></th>
					<td><input type="text" value='<%=(String)request.getAttribute("item_amount")%>' id="item_amount" name="item_amount" size="50"></td>
				</tr>
				<tr>
					<th><label class="imui-required"><%=bean.getMessage("SAMPLE.IMW.CAP.022")%></label></th>
					<td><input type="text" value='<%=(String)request.getAttribute("item_price")%>' id="item_price" name="item_price" size="50"></td>
				</tr>
				<tr>
					<th><label><%=bean.getMessage("SAMPLE.IMW.CAP.024")%></label></th>
					<td>
						<textarea id="item_comment" name="item_comment" rows="3" cols="40"><%=(String)request.getAttribute("item_comment")%></textarea>
					</td>
				</tr>
			</tbody>
		</table>
	
		<div class="imui-operation-parts">
			<imart:decision case="0" value='<%=(String)request.getAttribute("imwPageType")%>'>
				<imui:button value='<%=bean.getMessage("SAMPLE.IMW.CAP.003")%>' id="openPage0" name="openPage0" class="imui-large-button" escapeXml="true" escapeJs="false" />
				<imui:button value='<%=bean.getMessage("SAMPLE.IMW.CAP.002")%>' id="openPage1" name="openPage1" class="imui-large-button" escapeXml="true" escapeJs="false" />
			</imart:decision>
			<imart:decision case="1" value='<%=(String)request.getAttribute("imwPageType")%>'>
				<imui:button value='<%=bean.getMessage("SAMPLE.IMW.CAP.003")%>' id="openPage0" name="openPage0" class="imui-large-button" escapeXml="true" escapeJs="false" />
				<imui:button value='<%=bean.getMessage("SAMPLE.IMW.CAP.002")%>' id="openPage1" name="openPage1" class="imui-large-button" escapeXml="true" escapeJs="false" />
			</imart:decision>
			<imart:decision case="2" value='<%=(String)request.getAttribute("imwPageType")%>'>
				<imui:button value='<%=bean.getMessage("SAMPLE.IMW.CAP.003")%>' id="openPage2" name="openPage2" class="imui-large-button" escapeXml="true" escapeJs="false" />
			</imart:decision>
			<imart:decision case="3" value='<%=(String)request.getAttribute("imwPageType")%>'>
				<imui:button value='<%=bean.getMessage("SAMPLE.IMW.CAP.004")%>' id="openPage3" name="openPage3" class="imui-large-button" escapeXml="true" escapeJs="false" />
			</imart:decision>
		</div>
	</div>
</workflow:workflowOpenPage>

<form name="backForm" id="backForm" method="POST" action='<%=(String)request.getAttribute("imwCallOriginalPagePath")%>'>
    <input type="hidden" name=imwCallOriginalParams value='<%=(String)request.getAttribute("imwCallOriginalParams")%>' />
</form>
