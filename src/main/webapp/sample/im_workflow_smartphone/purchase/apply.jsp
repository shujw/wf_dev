<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="imartj2ee" uri="http://www.intra-mart.co.jp/taglib/core/framework" %>
<%@ taglib prefix="imui" uri="http://www.intra-mart.co.jp/taglib/imui" %>
<%@ taglib prefix="imart" uri="http://www.intra-mart.co.jp/taglib/core/standard" %>
<%@ taglib prefix="workflow" uri="http://www.intra-mart.co.jp/taglib/imw/workflow-smartphone" %>
<imartj2ee:HelperBean id="bean" class="jp.co.intra_mart.sample.workflow.purchase.controller.view.CommonHelperBean"/>

<imui:head>
  <title><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></title>
  <workflow:spWorkflowOpenPageCsjs />
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

  $(function(){
    $('#back').click(function(){
      $('#backForm').submit();
      return false;
    });
    $('#openPage0').click(function(){
      if (!imspValidate('#workflowOpenPageForm', rules, messages)) return;
      workflowOpenPage4Sp('10');
      return false;
    });
    $('#openPage1').click(function(){
      workflowOpenPage4Sp('11');
      return false;
    });
    $('#openPage2').click(function(){
      if (!imspValidate('#workflowOpenPageForm', rules, messages)) return;
      workflowOpenPage4Sp('12');
      return false;
    });
    $('#openPage3').click(function(){
      if (!imspValidate('#workflowOpenPageForm', rules, messages)) return;
      workflowOpenPage4Sp('13');
      return false;
    });
  });
  </script>
</imui:head>

<div data-role="page" id="imw-sp-sample-apply" data-theme="a">
  <div data-theme="a" data-role="header">
    <a href="#" class="ui-btn ui-btn-left ui-btn-icon-left ui-icon-back" id="back"><%=bean.getMessage("SAMPLE.IMW.CAP.001")%></a>
    <h1><%=bean.getMessage("SAMPLE.IMW.CAP.011")%></h1>
  </div>

  <div data-role="content">
    <workflow:spWorkflowOpenPage name="workflowOpenPageForm"
                                 id="workflowOpenPageForm"
                                 method="POST"
                                 target="_top"
                                 imwUserDataId='<%=(String)request.getAttribute("imwUserDataId")%>'
                                 imwSystemMatterId='<%=(String)request.getAttribute("imwSystemMatterId")%>'
                                 imwAuthUserCode='<%=(String)request.getAttribute("imwAuthUserCode")%>'
                                 imwApplyBaseDate='<%=(String)request.getAttribute("imwApplyBaseDate")%>'
                                 imwNodeId='<%=(String)request.getAttribute("imwNodeId")%>'
                                 imwFlowId='<%=(String)request.getAttribute("imwFlowId")%>'
                                 imwCallOriginalParams='<%=(String)request.getAttribute("imwCallOriginalParams")%>'
                                 imwNextScriptPath='<%=(String)request.getAttribute("imwCallOriginalPagePath")%>'>
      <ul data-role="listview" class="wrap">
        <li data-role="fieldcontain">
          <label for="item_name" class="imui-smart-ui-required"><%=bean.getMessage("SAMPLE.IMW.CAP.020")%></label>
          <input type="text" id="item_name" name="item_name" value='<%=(String)request.getAttribute("item_name")%>' data-theme="c" />
        </li>
        <li data-role="fieldcontain">
          <label for="item_amount" class="imui-smart-ui-required"><%=bean.getMessage("SAMPLE.IMW.CAP.021")%></label>
          <input type="number" id="item_amount" name="item_amount" value='<%=(String)request.getAttribute("item_amount")%>' data-theme="c" />
        </li>
        <li data-role="fieldcontain">
          <label for="item_price" class="imui-smart-ui-required"><%=bean.getMessage("SAMPLE.IMW.CAP.022")%></label>
          <input type="number" id="item_price" name="item_price" value='<%=(String)request.getAttribute("item_price")%>' data-theme="c" />
        </li>
        <li data-role="fieldcontain">
          <label for="item_comment"><%=bean.getMessage("SAMPLE.IMW.CAP.024")%></label>
          <textarea id="item_comment" name="item_comment" data-theme="c"><%=(String)request.getAttribute("item_comment")%></textarea>
        </li>
        <imart:decision case="10" value='<%=(String)request.getAttribute("imwPageType")%>'>
        <li data-role="fieldcontain">
          <fieldset class="ui-grid-a">
            <div class="ui-block-a"><button type="button" id="openPage0" data-theme="b"><%=bean.getMessage("SAMPLE.IMW.CAP.003")%></button></div>
            <div class="ui-block-b"><button type="button" id="openPage1" data-theme="b"><%=bean.getMessage("SAMPLE.IMW.CAP.002")%></button></div>
          </fieldset>
        </li>
        </imart:decision>
        <imart:decision case="11" value='<%=(String)request.getAttribute("imwPageType")%>'>
        <li data-role="fieldcontain">
          <fieldset class="ui-grid-a">
            <div class="ui-block-a"><button type="button" id="openPage0" data-theme="b"><%=bean.getMessage("SAMPLE.IMW.CAP.003")%></button></div>
            <div class="ui-block-b"><button type="button" id="openPage1" data-theme="b"><%=bean.getMessage("SAMPLE.IMW.CAP.002")%></button></div>
          </fieldset>
        </li>
        </imart:decision>
        <imart:decision case="12" value='<%=(String)request.getAttribute("imwPageType")%>'>
        <li data-role="fieldcontain">
          <fieldset>
            <div><button type="button" id="openPage2" data-theme="b"><%=bean.getMessage("SAMPLE.IMW.CAP.003")%></button></div>
          </fieldset>
        </li>
        </imart:decision>
        <imart:decision case="13" value='<%=(String)request.getAttribute("imwPageType")%>'>
        <li data-role="fieldcontain">
          <fieldset>
            <div><button type="button" id="openPage3" data-theme="b"><%=bean.getMessage("SAMPLE.IMW.CAP.004")%></button></div>
          </fieldset>
        </li>
        </imart:decision>
      </ul>
    </workflow:spWorkflowOpenPage>
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