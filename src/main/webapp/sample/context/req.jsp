<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
	"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="ja">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Request Information</title>
<style>
th {text-align: left;}
</style>
</head>

<body>
<h1>Request Information</h1>
<%-- Base --%>
<a name="base"></a>
<h2>Base</h2>
<table border="1" cellspacing="0">
<tr><th>getAuthType</th><td><%= request.getAuthType() %></td></tr>
<tr><th>getContextPath</th><td><%= request.getContextPath() %></td></tr>
<tr><th>getMethod</th><td><%= request.getMethod() %></td></tr>
<tr><th>getPathInfo</th><td><%= request.getPathInfo() %></td></tr>
<tr><th>getPathTranslated</th><td><%= request.getPathTranslated() %></td></tr>
<tr><th>getQueryString</th><td><%= request.getQueryString() %></td></tr>
<tr><th>getRemoteUser</th><td><%= request.getRemoteUser() %></td></tr>
<tr><th>getRequestedSessionId</th><td><%= request.getRequestedSessionId() %></td></tr>
<tr><th>getRequestURL</th><td><%= request.getRequestURL() %></td></tr>
<tr><th>getRequestURI</th><td><%= request.getRequestURI() %></td></tr>
<tr><th>getServletPath</th><td><%= request.getServletPath() %></td></tr>
<tr><th>isRequestedSessionIdFromCookie</th><td><%= request.isRequestedSessionIdFromCookie() %></td></tr>
<tr><th>isRequestedSessionIdFromURL</th><td><%= request.isRequestedSessionIdFromURL() %></td></tr>
<tr><th>isRequestedSessionIdValid</th><td><%= request.isRequestedSessionIdValid() %></td></tr>
<tr><th colspan="2">ServletRequest</th></tr>
<tr><th>getCharacterEncoding</th><td><%= request.getCharacterEncoding() %></td></tr>
<tr><th>getContentLength</th><td><%= request.getContentLength() %></td></tr>
<tr><th>getContentType</th><td><%= request.getContentType() %></td></tr>
<tr><th>getProtocol</th><td><%= request.getProtocol() %></td></tr>
<tr><th>getRemoteAddr</th><td><%= request.getRemoteAddr() %></td></tr>
<tr><th>getRemoteHost</th><td><%= request.getRemoteHost() %></td></tr>
<tr><th>getScheme</th><td><%= request.getScheme() %></td></tr>
<tr><th>getServerName</th><td><%= request.getServerName() %></td></tr>
<tr><th>getServerPort</th><td><%= request.getServerPort() %></td></tr>
<tr><th>isSecure</th><td><%= request.isSecure() %></td></tr>
</table>
<br>
<hr>

<%-- Cookies --%>
<a name="cookie"></a>
<h2>Cookies</h2>
<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
%>
<table border="1" cellspacing="0">
<%
		for (int i=0; i<cookies.length; i++) {
			Cookie c = cookies[i];
%>
	<tr><th><%= c.getName() %></th><td><%= c.getValue() %></td></tr>
<% 	} %>
</table>
<% } %>
<br>
<hr>

<%-- Headers --%>
<a name="header"></a>
<h2>Headers</h2>
<%
	Enumeration enumeration = request.getHeaderNames();
	if (enumeration != null) {
%>
<table border="1" cellspacing="0">
<%
		while (enumeration.hasMoreElements()) {
			String name = (String)enumeration.nextElement();
%>
	<tr><th><%= name %></th><td><%= request.getHeader(name) %></td></tr>
<% 	} %>
</table>
<% } %>
<br>
<hr>

<%-- Request Attributes --%>
<a name="attribute"></a>
<h2>Request Attributes</h2>
<%
	enumeration = request.getAttributeNames();
	if (enumeration != null) {
%>
<table border="1" cellspacing="0">
<%
		while (enumeration.hasMoreElements()) {
			String name = (String)enumeration.nextElement();
%>
	<tr><th><%= name %></th><td><%= request.getAttribute(name) %></td></tr>
<% 	} %>
</table>
<% } %>
<br>
<hr>


<%-- Session Attributes --%>
<a name="session"></a>
<h2>Session Attributes</h2>
<%
	if (session != null) {
	enumeration = session.getAttributeNames();
	if (enumeration != null) {
%>
<table border="1" cellspacing="0">
<%
		while (enumeration.hasMoreElements()) {
			String name = (String)enumeration.nextElement();
%>
	<tr><th><%= name %></th><td><%= session.getAttribute(name) %></td></tr>
<% 	} %>
</table>
<% } } %>
<br>
<hr>


<%-- Page Attributes --%>
<a name="page"></a>
<h2>Page Attributes</h2>
<%
	if (pageContext != null) {
	enumeration = pageContext.getAttributeNamesInScope(PageContext.PAGE_SCOPE);
	if (enumeration != null) {
%>
<table border="1" cellspacing="0">
<%
		while (enumeration.hasMoreElements()) {
			String name = (String)enumeration.nextElement();
%>
	<tr><th><%= name %></th><td><%= pageContext.getAttribute(name) %></td></tr>
<% 	} %>
</table>
<% } } %>
<br>
<hr>

<%-- Locales --%>
<a name="locale"></a>
<h2>Locales</h2>
<table border="1" cellspacing="0">
	<tr><th>Prefered</th><td><%= request.getLocale() %></td></tr>
<%
	enumeration = request.getLocales();
	if (enumeration != null) {
%>
<%
		int i = 0;
		while (enumeration.hasMoreElements()) {
%>
	<tr><th><%= i++ %></th><td><%= enumeration.nextElement() %></td></tr>
<% 	} %>
<% } %>
</table>
<br>
<hr>

<%-- Request Parameters --%>
<a name="param"></a>
<h2>Request Parameters</h2>
<%
	enumeration = request.getParameterNames();
	if (enumeration != null) {
%>
<table border="1" cellspacing="0">
<%
		while (enumeration.hasMoreElements()) {
			String name = (String)enumeration.nextElement();
%>
	<tr><th><%= name %></th><td><%= request.getParameter(name) %></td></tr>
<% 	} %>
</table>
<% } %>
<br>
<hr>

<%-- Request Parameters2 --%>
<a name="param2"></a>
<h2>Request Parameters2</h2>
<%
	Map<String, String[]> map = request.getParameterMap();
	if (map != null) {
%>
<table border="1" cellspacing="0">
<%
        Set<Map.Entry<String, String[]>> entries = map.entrySet();
        for(Map.Entry<String, String[]> entry : entries) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            StringBuffer value = new StringBuffer();
//            if (values != null)
//                for (int i=0; i<values.length; i++) {System.out.println(values[i]);value.append('[').append(values[i]).append("],");}
%>
	<tr><th><%= entry.getKey() %></th><td><%= value.toString() %></td></tr>
<% 	} %>
</table>
<% } %>
</body>
</html>
