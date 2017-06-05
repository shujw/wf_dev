<%--
コンテキスト表示（埋め込み用）

保存されているコンテキストを全て表示する。

--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.beans.Introspector" %>
<%@ page import="java.beans.PropertyDescriptor" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.util.*" %>

<%@ page import="jp.co.intra_mart.foundation.context.model.*" %>
<%@ page import="jp.co.intra_mart.foundation.context.core.*" %>
<%@ page import="jp.co.intra_mart.foundation.context.web.*" %>
<%@ page import="jp.co.intra_mart.system.context.core.*" %>
<%@ page import="jp.co.intra_mart.system.context.core.cache.*" %>
<%@ page import="jp.co.intra_mart.system.context.impl.cache.*" %>
<%@ page import="jp.co.intra_mart.system.context.impl.*" %>
<%@ page import="jp.co.intra_mart.system.context.manager.*" %>
<%@ page import="jp.co.intra_mart.system.context.model.*" %>
<%@ page import="jp.co.intra_mart.system.context.util.*" %>

<%!

static class TestUtil {

	/**
	 * context.jsp に表示するための情報を取得するメソッド
	 */
	public static final List<Map<String, String>> getPropertyListFromObject(Object o) {
		List<Map<String, String>> propertyList = new ArrayList<Map<String, String>>();
		try {
			PropertyDescriptor[] descs = Introspector.getBeanInfo(o.getClass()).getPropertyDescriptors();
			for (PropertyDescriptor desc : descs) {
				Map<String, String> propertyMap = new HashMap<String, String>();

				Method m = desc.getReadMethod();
				String name = desc.getName();
				if (m == null || "class".equals(name)) continue;
				Class<?> t = desc.getPropertyType();
				Object value = m.invoke(o);

				propertyMap.put("key", "context." + name);
				propertyMap.put("name", name);

				if (boolean.class.equals(t) || Boolean.class.equals(t)) {
					propertyMap.put("type", "radio");
					propertyMap.put("caption1", "true");
					propertyMap.put("caption2", "false");
				} else {
					propertyMap.put("type", "text");
					propertyMap.put("size", "80");
				}

				if (int.class.equals(t) || Integer.class.equals(t)) {
					propertyMap.put("rule", "integer");
					propertyMap.put("size", "5");
				}
				if (value instanceof Locale) {
					propertyMap.put("default", String.valueOf(value));
				} else if (value instanceof TimeZone) {
					propertyMap.put("default", ((TimeZone) value).getID());
				} else if (value instanceof String) {
					propertyMap.put("default", String.valueOf(value));
				} else if (value instanceof Number) {
					propertyMap.put("default", String.valueOf(value));
				} else if (value instanceof Boolean) {
					propertyMap.put("default", String.valueOf(value));
				} else if (value instanceof Class) {
					propertyMap.put("default", "class " + ((Class) value).getSimpleName());
				} else {
					propertyMap.put("default", getClassName(value));
				}
				propertyMap.put("value", String.valueOf(value));

				propertyList.add(propertyMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return propertyList;
	}

	public static final <T> T invoke(Class<?> c, Object o, String methodName) {
		T result = null;
		try {
			Method m = c.getDeclaredMethod(methodName);
			m.setAccessible(true);
			result = (T) m.invoke(o);
		} catch (Exception e) {
			System.out.println("invoke error: " + methodName + ": " + e.toString());
		}
		return result;
	}

//	public static final Context getInternal(Context decorator) {
//		if (decorator == null || !(decorator instanceof ContextSupport)) return null;
//		Context result = null;
//		try {
//			result = (Context) invoke(ContextSupport.class, decorator, "getInternal");
//		} catch (Exception e) {}
//		return result;
//	}

	public static final String getClassName(Object o) {
		if (o == null) return null;
		return o.getClass().getSimpleName();
	}

}

%>

<section>
	<header class="imui-title">
		<h1>全コンテキスト</h1>
	</header>
<%
try {
ThreadContextStore contextStore = (ThreadContextStore) ContextManager.getInstance().getContextStore();

Map<String, String> policyConfig = new HashMap<String, String>();
policyConfig.put("cache-policy", "session-daily");
ContextCachePolicy policy = ContextCachePolicyFactory.getInstance().getCachePolicy(policyConfig);

// 全コンテキスト取得
Map<Class<?>, Context> contexts = contextStore.getAll();

if (contexts != null) {

for (Map.Entry<Class<?>, Context> entry : contexts.entrySet()) {
	Context context = entry.getValue();

if (context != null) {
	String contextType = context.getType().getName();
	String defauleResourceId = ContextScope.get(context.getType(), "debug.defaultResourceId");
	ContextCache cache = (ContextCache) session.getAttribute(contextType + ".cache");
	Context cachedContext = cache != null ? cache.getContext() : null;
//	Context cachedContext = policy != null ? policy.getContext(contextType, new HttpResource("platform.request", null, request, response)) : null;

	List<Map<String, String>> propertyList = null;
	List<Map<String, String>> cachedPropertyList = null;
%>

	<div class="imui-chapter-title mt-20"><h2>Context: <%= contextType %></h2></div>
	<table width="90%" class="imui-table mt-20">
		<tr align="center">
<%
	// プロパティを表示情報に変換
	propertyList = TestUtil.getPropertyListFromObject(context);
	String cacheInfo = null;
	if (cachedContext != null) {
		cachedPropertyList = TestUtil.getPropertyListFromObject(cachedContext);
		cacheInfo = ContextScope.get(cachedContext.getType(), "debug.cacheInfo");
	}
%>
			<td class="list_data_bg_left" style="background-color: #ffffe2;">
				<table width="90%" class="imui-table mt-20">
					<tr>
						<th class="wd-20">Property Name</th>
						<th class="wd-20">Contexts.get()</th>
						<th class="wd-20">Cached Context</th>
					</tr>
					<tr>
						<th>Context Class</th>
						<td title="<%= context %>"><%= TestUtil.getClassName(context) %></td>
						<td title="<%= cachedContext %>"><%= TestUtil.getClassName(cachedContext) %></td>
					</tr>
					<tr>
						<th>&nbsp;</th>
						<td><%= (defauleResourceId != null) ? "Default Resource Id: " + defauleResourceId : "" %></td>
						<td><%= (cacheInfo != null) ? "Cache Info: " + cacheInfo : "" %></td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
					<%
						int i=0;
						for (Map<String, String> property : propertyList) {
							Map<String, String> cachedProperty = cachedPropertyList != null ? cachedPropertyList.get(i) : null;
							i++;
					%>
					<%
						String type = property.get("type");
						String key = property.get("key");
						String name = property.get("name");
						String defaultValue = property.get("default");
						String value = property.get("value");
						String size = property.get("size");
						String rule = property.get("rule");
					%>
					<tr>
						<th><%= name %></th>
						<%-- radio --%>
						<% if (type.equals("radio")) { %>
						<td><%= Boolean.valueOf(defaultValue) %></td>
						<td><%= cachedProperty != null ? String.valueOf(cachedProperty.get("default")) : "null" %></td>
						<% } %>

						<%-- text --%>
						<% if (type.equals("text")) { %>
						<td title="<%= value %>"><%= String.valueOf(defaultValue) %></td>
						<td title="<%= cachedProperty != null ? String.valueOf(cachedProperty.get("value")) : "null" %>"><%= cachedProperty != null ? String.valueOf(cachedProperty.get("default")) : "null" %></td>
						<% } %>
					</tr>
					<% } // for (Map<String, String> property : propertyList) { %>

				</table>
			</td>
		</tr>

<%
	// プロパティを表示情報に変換
	Map<String, Object> attributes = TestUtil.invoke(ContextBase.class, cachedContext, "getAttributes");
	if (attributes != null && !attributes.isEmpty()) {
%>
		<tr>
			<td class="list_data_bg_left" style="background-color: #ffffe2;">
				<div class="imui-chapter-title mt-20"><h2 class="mlc-module-title"></h2>Attributes</div>
				<table width="90%" class="imui-table mt-20">
					<tr>
						<th class="wd-20">Key</th>
						<th class="wd-20">Value</th>
					</tr>
					<%
						i=0;
						for (Map.Entry<String, Object> attribute : attributes.entrySet()) {
					%>
					<tr>
						<th><%= attribute.getKey() %></th>
						<td><%= String.valueOf(attribute.getValue()) %></td>
					</tr>
					<% } // for (Map.Entry<String, Object> attribute : attributes.entrySet()) { %>

				</table>
			</td>
		</tr>

<%
	} // if (attributes != null && !attributes.isEmpty()) {
%>

	</table>
	<br>
<%
	} // if (context != null) {
	} // for (Map.Entry<Class<?>, Context> entry : contexts.entrySet()) {
	} // if (contexts != null) {
} catch (Exception e) {
	e.printStackTrace();
}
%>
</section>
