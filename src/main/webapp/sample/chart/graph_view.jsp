<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="imui" uri="http://www.intra-mart.co.jp/taglib/imui"%>

<imui:head>
  <title>グラフ描画モジュール サンプル</title>
</imui:head>
<div class="imui-title">
  <h1>グラフ描画モジュール サンプル</h1>
</div>
<div class="imui-toolbar-wrap">
  <div class="imui-toolbar-inner">
    <ul class="imui-list-toolbar-utility">
      <li><a href="sample/java/chart/view" class="imui-toolbar-icon" title='最新情報'><span class="im-ui-icon-common-16-refresh"></span></a></li>
    </ul>
  </div>
</div>

<div id="imui-container-inner">
  <imui:tabs id="tabs">
    <imui:tabItem href="sample/java/chart/default" title="標準グラフ" id="tabDefault" />
    <imui:tabItem href="sample/java/chart/3d" title="3Dグラフ" id="tab3D" />
    <imui:tabItem href="sample/java/chart/custom" title="カスタムグラフ" id="tabCustom" />
  </imui:tabs>
</div>
