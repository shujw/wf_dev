<%--
コンテキストビルダー情報表示
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.beans.Introspector" %>
<%@ page import="java.beans.PropertyDescriptor" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.util.*" %>

<%@ page import="jp.co.intra_mart.foundation.context.model.*" %>
<%@ page import="jp.co.intra_mart.foundation.context.core.*" %>
<%@ page import="jp.co.intra_mart.foundation.context.config.*" %>
<%@ page import="jp.co.intra_mart.system.context.impl.*" %>
<%@ page import="jp.co.intra_mart.system.context.manager.*" %>
<%@ page import="jp.co.intra_mart.system.context.manager.*" %>
<%@ page import="jp.co.intra_mart.system.context.manager.ContextBuilderInfo.ContextBuilderList" %>
<%@ page import="jp.co.intra_mart.system.context.manager.impl.*" %>
<%@ page import="jp.co.intra_mart.system.context.util.*" %>

<h2>ContextConfig</h2>
<%
ContextConfig contextConfig = ContextConfiguration.get();
%>
<textarea cols="120" rows="20"><%= ConfigUtil.toString(contextConfig) %></textarea><br>


<h2>ContextBuilders</h2>
<%
ContextBuilderInfo builders = ContextManagerProducer.getContextBuilders();
for (final ContextBuilderList builderList : builders.values()) {
    for (final ContextBuilder builder : builderList) {
%>
target= <%= builder.getBuilderInfo().getTarget() %>,
class= <%= builder.getBuilderInfo().getBuilderClass() %><br>
<textarea cols="120" rows="10"><%= ConfigUtil.toString(builder.getBuilderInfo()) %></textarea><br>
<%
    }
}
%>
<br>
