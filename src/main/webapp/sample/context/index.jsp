<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ui:head>
<title></title>
<style type="text/css">
	body {background-color: #ffffff;}
	.table_area {background-color: #ffffee;}
	.table_header {background-color: #ffeeee;}
	.table_data {background-color: #eeeeff;}
</style>
<script type="text/javascript" language="JavaScript">
</script>
</ui:head>
<div id="imui-container-inner">
  <table class="imui-table mt-20">
    <tbody>
      <tr>
        <th colspan="2">TOP</th>
      </tr>
      <tr>
        <td nowrap>コンテキスト表示(JSSP)</td><td><a href="sample/context/client_context_view" target="iwp">クライアントコンテキスト</a></td>
      </tr>
      <tr>
        <td nowrap>コンテキスト表示(JSP)</td><td><a href="sample/context/client_context_view.jsp" target="iwp">クライアントコンテキスト</a></td>
      </tr>
      <tr>
        <td nowrap>コンテキスト表示(JSSP)</td><td><a href="sample/context/account_context_view" target="iwp">アカウントコンテキスト</a></td>
      </tr>
      <tr>
        <td nowrap>コンテキスト表示(JSP)</td><td><a href="sample/context/account_context_view.jsp" target="iwp">アカウントコンテキスト</a></td>
      </tr>
      <tr>
        <td nowrap>コンテキスト表示(JSSP)</td><td><a href="sample/context/user_context_view" target="iwp">ユーザコンテキスト</a></td>
      </tr>
      <tr>
        <td nowrap>コンテキスト表示(JSP)</td><td><a href="sample/context/user_context_view.jsp" target="iwp">ユーザコンテキスト</a></td>
      </tr>
      <tr>
        <td nowrap>コンテキスト表示(JSP)</td><td><a href="sample/context/context_view.jsp" target="iwp">全コンテキスト</a></td>
      </tr>
      <tr>
        <td>ユーティリティ</td><td><a href="sample/context/session_view.jsp" target="_blank">セッション情報 （セッション無効化可）</a></td>
      </tr>
      <tr>
        <td>ユーティリティ</td><td><a href="sample/context/req.jsp" target="_blank">リクエスト情報</a></td>
      </tr>
      <tr>
        <td>ユーティリティ</td><td><a href="sample/context/context_builder_view.jsp" target="_blank">コンテキストビルダー情報（デバッグ用）</a></td>
      </tr>
    </tbody>
  </table>
</div>