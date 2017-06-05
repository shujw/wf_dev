<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="imartj2ee" uri="http://www.intra-mart.co.jp/taglib/core/framework" %>
<%@ taglib prefix="imui" uri="http://www.intra-mart.co.jp/taglib/imui" %>
<%@ taglib prefix="workflow" uri="http://www.intra-mart.co.jp/taglib/imw/workflow-smartphone" %>
<imartj2ee:HelperBean id="bean" class="jp.co.intra_mart.sample.workflow.purchase.controller.view.CommonHelperBean"/>

<imui:head>
  <title><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></title>
  <workflow:spWorkflowOpenPageCsjs />
  <script type="text/javascript">
  $(function($){
    $('#back').click(function(){
      $('#backForm').submit();
      return false;
    });
    $('#openPage').click(function(){
      workflowOpenPage4Sp('<%=(String)request.getAttribute("imwPageType")%>');
      return false;
    });
  });
  </script>
</imui:head>

<div data-role="page" id="imw-sp-sample-confirm" data-theme="a">
  <div data-theme="a" data-role="header">
    <a href="#" class="ui-btn ui-btn-left ui-btn-icon-left ui-icon-back" id="back"><%=bean.getMessage("SAMPLE.IMW.CAP.001")%></a>
    <h1><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></h1>
  </div>

  <div data-role="content">
    <workflow:spWorkflowOpenPage name="workflowOpenPageForm"
                                 method="POST"
                                 target="_top"
                                 imwSystemMatterId='<%=(String)request.getAttribute("imwSystemMatterId")%>'
                                 imwNodeId='<%=(String)request.getAttribute("imwNodeId")%>'
                                 imwCallOriginalParams='<%=(String)request.getAttribute("imwCallOriginalParams")%>'
                                 imwNextScriptPath='<%=(String)request.getAttribute("imwCallOriginalPagePath")%>' />
    <ul data-role="listview" class="wrap">
      <li>
        <label class="ui-select" style="opacity:0.6"><%=bean.getMessage("SAMPLE.IMW.CAP.020")%></label>
        <div style="font-size:16px;padding:3px 0 0 24px;text-shadow:0.5px 0.5px 0.5px #000;">
          <%=(String)request.getAttribute("item_name")%>
        </div>
      </li>
      <li>
        <label class="ui-select" style="opacity:0.6"><%=bean.getMessage("SAMPLE.IMW.CAP.021")%></label>
        <div style="font-size:16px;padding:3px 0 0 24px;text-shadow:0.5px 0.5px 0.5px #000;">
          <%=(String)request.getAttribute("item_amount")%>
        </div>
      </li>
      <li>
        <label class="ui-select" style="opacity:0.6"><%=bean.getMessage("SAMPLE.IMW.CAP.022")%></label>
        <div style="font-size:16px;padding:3px 0 0 24px;text-shadow:0.5px 0.5px 0.5px #000;">
          <%=(String)request.getAttribute("item_price")%>
        </div>
      </li>
      <li>
        <label class="ui-select" style="opacity:0.6"><%=bean.getMessage("SAMPLE.IMW.CAP.023")%></label>
        <div style="font-size:16px;padding:3px 0 0 24px;text-shadow:0.5px 0.5px 0.5px #000;">
          <%=(String)request.getAttribute("item_total")%>
        </div>
      </li>
      <li>
        <label for="item_comment"><%=bean.getMessage("SAMPLE.IMW.CAP.024")%></label>
        <textarea id="item_comment" name="item_comment" data-theme="c" readonly="readonly"><%=(String)request.getAttribute("item_comment")%></textarea>
      </li>
      <li data-role="fieldcontain">
        <fieldset>
          <div><button type="button" id="openPage" data-theme="b"><%=bean.getMessage("SAMPLE.IMW.CAP.006")%></button></div>
        </fieldset>
      </li>
    </ul>
  </div>

  <div data-role="footer" class="imui-smart-footer" data-position="fixed" data-theme="a">
    <div data-role="navbar">
      <ul>
        <li><a href='<%=bean.getHomeUrl()%>' data-icon="custom" class="im-smart-icon-common-32-home-navbar" data-iconpos="top" data-ajax="false"></a></li>
        <li><a href="#"></a></li>
        <li><a href="#"></a></li>
        <li><a href="#"></a></li>
        <li><a href="#"></a></li>
      </ul>
    </div>
  </div>

  <form name="backForm" id="backForm" method="POST" action='<%=(String)request.getAttribute("imwCallOriginalPagePath")%>' data-ajax="false">
      <input type="hidden" name=imwCallOriginalParams value='<%=(String)request.getAttribute("imwCallOriginalParams")%>' />
  </form>
</div>