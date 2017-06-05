<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="imui" uri="http://www.intra-mart.co.jp/taglib/imui" %>

<%
String parentCallBackFunction = (String)request.getAttribute("parentCallBackFunction");
String extensionPointId       = (String)request.getAttribute("extensionPointId");
String pluginId               = (String)request.getAttribute("pluginId");
String parameter              = (String)request.getAttribute("parameter");
String pluginName             = (String)request.getAttribute("pluginName");
String displayName            = (String)request.getAttribute("displayName");
String targetDate             = (String)request.getAttribute("targetDate");
String targetType             = (String)request.getAttribute("targetType");
String targetCode             = (String)request.getAttribute("targetCode");
%>

<imui:head>
<script type="text/javascript">
function callBack() {
    var returnObject = [
                         {
                           "extensionPointId" : "<%=extensionPointId%>",
                           "pluginId"         : "<%=pluginId%>",
                           "parameter"        : "<%=parameter%>",
                           "pluginName"       : "<%=pluginName%>",
                           "displayName"      : "<%=displayName%>",
                           "targetDate"       : "<%=targetDate%>",
                           "targetType"       : "<%=targetType%>",
                           "targetCode"       : "<%=targetCode%>"
                         }
                       ];
    parent['<%=parentCallBackFunction%>'](returnObject);
}
</script>
</imui:head>
<body onload="javascript:callBack();"></body>
