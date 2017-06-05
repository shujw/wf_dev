<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://www.intra-mart.co.jp/taglib/imui"%>
<%@ taglib prefix="imaz" uri="http://www.intra-mart.co.jp/taglib/im-tenant"%>
<ui:head>
<script type="text/javascript" src="csjs/im_json.js"></script>
<script type="text/javascript" src="csjs/im_ajax_request.js"></script>
<imaz:imAuthzPolicyEditor displayType="script" partId="im_authz_impl_router" />

<script type="text/javascript">
$(document).ready(function($) {
  $('#openAuthDialog').click(function() {
    ImAuthzPolicyEditor.open({
      'partId':'im_authz_impl_router',
      'highlightResource':'im-authz-service'
    });
  });
});
</script>

</ui:head>

<section>
<header class="imui-title">
  <h1>ImAuthzPolicyEditor サンプル</h1>
</header>

<article style="width:80%; margin:auto">
<form onsubmit="return false">

  <div class="imui-chapter-title mt-20"><h2>ボタン</h2></div>
  <div class="imui-list-tabPanel">

  <div class="code"><u>サンプル</u><pre>

  <b>&lt;imaz:imAuthzPolicyEditor</b> displayType=&quot;<b><u>button</u></b>&quot;
      partId=&quot;im_authz_impl_router&quot;
      class=&quot;imui-small-button&quot;
      highlightResource=&quot;im-authz-service&quot;&gt;</b>ボタンで表示<b>&lt;/imaz:imAuthzPolicyEditor&gt;</b>

  </pre></div>

  <table class="imui-table mt-20">
    <tr>
      <td class="bottom">実行： <imaz:imAuthzPolicyEditor displayType="button" class="imui-small-button"
          partId="im_authz_impl_router" highlightResource="im-authz-service">ボタンで表示</imaz:imAuthzPolicyEditor></td>
    </tr>
  </table>

  <div class="imui-chapter-title mt-20"><h2>リンク</h2></div>
  <div class="imui-list-tabPanel">

  <div class="code"><u>サンプル</u><pre>

  <b>&lt;imaz:imAuthzPolicyEditor</b> displayType=&quot;<b><u>link</u></b>&quot;
      partId=&quot;im_authz_impl_router&quot;
      highlightResource=&quot;im-authz-service&quot;&gt;</b>リンクで表示<b>&lt;/imaz:imAuthzPolicyEditor&gt;</b>

  </pre></div>

  <table class="imui-table mt-20">
    <tr>
      <td class="bottom">実行： <imaz:imAuthzPolicyEditor displayType="link"
          partId="im_authz_impl_router" highlightResource="im-authz-service">リンクで表示</imaz:imAuthzPolicyEditor></td>
    </tr>
  </table>

  <div class="imui-chapter-title mt-20"><h2>スクリプト</h2></div>
  <div class="imui-list-tabPanel">

  <div class="code"><u>サンプル</u><pre>

    <b>&lt;imaz:imAuthzPolicyEditor</b> displayType=&quot;<b><u>script</u></b>&quot;
        partId=&quot;im_authz_impl_router&quot; /&gt;
    &lt;script type=&quot;text/javascript&quot;&gt;
    $(document).ready(function($) {
      $('#openAuthDialog').click(function() {
        <b>ImAuthzPolicyEditor.open</b>({
          'partId':'im_authz_impl_router'
          'highlightResource':'im-authz-service'
        });
      });
    });
    &lt;/script&gt;

  </pre></div>

  <table class="imui-table mt-20">
    <tr>
      <td class="bottom">実行： <button id="openAuthDialog" class="imui-small-button">動的で実行</button></td>
    </tr>
  </table>

  <div class="imui-chapter-title mt-20"><h2>partId</h2></div>
  <div class="imui-list-tabPanel">
    <table class="imui-table mt-20">
      <tr>
        <td class="bottom">絞込み用のID ・・・ リソースグループ・サブジェクトタイプの絞込みを定義するID<br>
        <br>
        →「/conf/authz-partial-policy-edit-config/im_authz_sample.xml」 を参照</td>
      </tr>
    </table>
  </div>

  </form>
</article>
</section>
