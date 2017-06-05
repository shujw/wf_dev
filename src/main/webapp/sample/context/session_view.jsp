<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.beans.*" %>
<%@ page import="java.lang.reflect.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%!
private static String getBeanInfo(Object bean) {
	if (bean == null) return "null";

	Class clazz = bean.getClass();
	try {
	BeanInfo info = Introspector.getBeanInfo(clazz);
	PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
	StringBuffer buffer = new StringBuffer();
	long total = 0;
	for (int i=0; i<descriptors.length; i++) {
		buffer.append("<tr>");

		PropertyDescriptor descriptor = descriptors[i];
//		if (descriptor instanceof IndexedPropertyDescriptor) {
//		} else {
			Class<?> propertyClass = descriptor.getPropertyType();
			String typeName = propertyClass.getName();
			int pos = typeName.lastIndexOf('.');
			if (pos > -1) typeName = typeName.substring(pos+1);
			buffer.append("<td>").append(typeName).append("</td>");

			String name = descriptor.getName();
			buffer.append("<th>").append(name).append("</th>");
			Method reader = descriptor.getReadMethod();
			if (reader != null) {
				try {
					buffer.append("<td>");

					Object value = reader.invoke(bean);
					long length = 4l;
					if (value == null) {
						length = 0;
					} else if (value instanceof List) {
						length = getListInfo((List)value, buffer);
						value = "";
					} else if (value instanceof String) {
						length = ((String)value).getBytes().length;
						if (length > 60) value = ((String)value).substring(0, 60);
					} else if (value instanceof StringBuffer) {
						length = ((StringBuffer)value).capacity() * 2;
						if (length > 60) value = ((StringBuffer)value).substring(0, 60);
					} else if (value.getClass().isArray()) {
						Class<?> componentType = value.getClass().getComponentType();
						length = ((Object[])value).length;
					}
					if ("content".equals(name)) {
						value = "...";
					}
					buffer.append(value).append("</td>");
					buffer.append("<td>").append(length).append("</td>");
					total += length;
				} catch (Exception e) {
					buffer.append("<td>***</td>");
					buffer.append("<td>???</td>");
				}
			} else {
				buffer.append("<td>***</td>");
				buffer.append("<td>???</td>");
			}
//		}
		buffer.append("</tr>");
	}
	buffer.append("<tr style='background-color:#ffcccc;'><td colspan='3'><td >").append(total).append("</td></tr>");
	return buffer.toString();

	} catch (Exception e) {
		e.printStackTrace();
		return "";
	}
}
private static long getListInfo(List list, StringBuffer buffer) {
	if (list == null) return 0;

	buffer.append("<table border='1' cellspacing='0'>");
	
	long total = 0;
	
	for (Iterator it = list.iterator(); it.hasNext(); ) {
		long length = 4l;
		Object value = it.next();
		
		if (true) {
			if (value instanceof List) {
				buffer.append("<tr><td>List:");
				total += getListInfo((List)value, buffer);
				buffer.append("</td></tr>");
			} else {
				buffer.append("<tr><th colspan='4' style='background-color:#ccccff'>Bean:</th></tr>");
				buffer.append(getBeanInfo(value));
			}
			continue;
		}

		buffer.append("<tr>");
		buffer.append("<td>");
		if (value == null) {
		} else if (value instanceof List) {
//			length = getListInfo((List)value);
		} else if (value instanceof String) {
			length = ((String)value).getBytes().length;
		} else if (value instanceof StringBuffer) {
			length = ((StringBuffer)value).capacity() * 2;
		} else if (value.getClass().isArray()) {
			Class<?> componentType = value.getClass().getComponentType();
			length = ((Object[])value).length;
		}

		buffer.append(value);
		buffer.append("</td>");
		buffer.append("</tr>");
		total += length;

	}

	buffer.append("</table>");
	return total;

}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
	"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="ja">
<meta http-equiv="Content-Style-Type" content="text/css">
<title>Session Information</title>
<style>
th {text-align: left;}
</style>
</head>

<body>
<h1>Session Information</h1>
<form method="POST">
	<input type="submit" name="invalidate" value="Session Invalidate">
</form>
<%-- Base --%>
<a name="base"></a>
<h2>Base</h2>
<table border="1" cellspacing="0">
<tr><th>getRequestedSessionId</th><td><%= request.getRequestedSessionId() %></td></tr>
<tr><th>isRequestedSessionIdFromCookie</th><td><%= request.isRequestedSessionIdFromCookie() %></td></tr>
<tr><th>isRequestedSessionIdFromURL</th><td><%= request.isRequestedSessionIdFromURL() %></td></tr>
<tr><th>isRequestedSessionIdValid</th><td><%= request.isRequestedSessionIdValid() %></td></tr>
<tr><th>getId</th><td><%= session.getId() %></td></tr>
<tr><th>getCreationTime</th><td><%= new Date(session.getCreationTime()) %></td></tr>
<tr><th>getLastAccessedTime</th><td><%= new Date(session.getLastAccessedTime()) %></td></tr>
<tr><th>getMaxInactiveInterval</th><td><%= session.getMaxInactiveInterval() %></td></tr>
<tr><th>isNew</th><td><%= session.isNew() %></td></tr>
</table>
<br>
<hr>


<%-- Session Attributes --%>
<a name="session"></a>
<h2>Session Attributes</h2>
<%
	if (session != null) {
	Enumeration enumeration = session.getAttributeNames();
	if (enumeration != null) {
%>
<table border="1" cellspacing="0">
<%
		System.out.println("...Try to serializable session attributes.");
		while (enumeration.hasMoreElements()) {
			String name = (String)enumeration.nextElement();
			try {
				java.io.ObjectOutputStream o = new java.io.ObjectOutputStream(new java.io.ByteArrayOutputStream());
				o.writeObject(session.getAttribute(name));
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
%>
	<tr><th><%= name %></th><td><%= session.getAttribute(name) %></td></tr>
<% 	} %>
</table>
<% } } %>
<br>
<hr>
<%
if (request.getParameter("invalidate") != null)
	session.invalidate();
%>


</body>
</html>
