<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.intra-mart.co.jp/taglib/foundation/chart" prefix="imchart"%>

<%@page import="jp.co.intra_mart.foundation.chart.dataset.*"%>
<%@page import="jp.co.intra_mart.foundation.chart.data.*"%>
<%@page import="jp.co.intra_mart.foundation.chart.graphInfo.*"%>

<%
response.setContentType("text/plain; charset=UTF-8");

	// 【１】円グラフ用サンプルデータ
	PieGraphInfo pieGraphInfo = new PieGraphInfo();
	PieDataset pieDataset = new PieDataset();
	pieDataset.addDataset(new PieData("東京支店", 700));
	pieDataset.addDataset(new PieData("大阪支店", 300));
	pieDataset.addDataset(new PieData("神奈川支店", 250));
	pieDataset.addDataset(new PieData("千葉支店", 302));
	pieDataset.addDataset(new PieData("名古屋支店", 155));
	pieDataset.addDataset(new PieData("埼玉支店", 400));
	pieGraphInfo.setDataset(pieDataset);

	// 【２】棒グラフサンプルデータ（一般棒グラフ）
	BarGraphInfo barGraphInfo = new BarGraphInfo();
	BarDataset barDataset = new BarDataset();

	StandardData barSeries1 = new StandardData();
	barSeries1.setName("東京支店");
	barSeries1.setValues(new Number[] { 300, 200, 400, 500, 250, 380 });

	StandardData barSeries2 = new StandardData();
	barSeries2.setName("大阪支店");
	barSeries2.setValues(new Number[] { 190, 320, 320, 500, 410, 230 });

	barDataset.setCategory(new String[] { "1月", "２月", "３月", "４月", "５月", "６月" });
	barDataset.addData(barSeries1);
	barDataset.addData(barSeries2);
	barGraphInfo.setDataset(barDataset);

	// 【３】棒グラフサンプルデータ（積上げグラフ）
	BarGraphInfo stackedBarInfo = new BarGraphInfo();
	BarDataset stackedData = new BarDataset();

	StandardData stackedSeries1 = new StandardData();
	stackedSeries1.setName("東京支店");
	stackedSeries1.setValues(new Number[] { 300, 200, 400, 500, 250, 380 });

	StandardData stackedSeries2 = new StandardData();
	stackedSeries2.setName("大阪支店");
	stackedSeries2.setValues(new Number[] { 500, 250, 400, 180, 200, 300 });

	stackedData.setCategory(new String[] { "1月", "２月", "３月", "４月", "５月", "６月" });
	stackedData.addData(stackedSeries1);
	stackedData.addData(stackedSeries2);

	stackedBarInfo.setDataset(stackedData);
	stackedBarInfo.setStyle(ChartConstant.BAR_GRAPH_STYLE_STACKED);

	// 【４】棒グラフサンプルデータ（100%積上げグラフ）
	BarGraphInfo persentageBarInfo = new BarGraphInfo();
	BarDataset persentageBarData = new BarDataset();

	StandardData persentageSeries1 = new StandardData();
	persentageSeries1.setName("東京支店");
	persentageSeries1.setValues(new Number[] { 300, 200, 400, 500, 250, 380 });

	StandardData persentageSeries2 = new StandardData();
	persentageSeries2.setName("大阪支店");
	persentageSeries2.setValues(new Number[] { 500, 250, 400, 180, 200, 300 });

	persentageBarData.setCategory(new String[] { "1月", "２月", "３月", "４月", "５月", "６月" });
	persentageBarData.addData(persentageSeries1);
	persentageBarData.addData(persentageSeries2);

	persentageBarInfo.setDataset(persentageBarData);
	persentageBarInfo.setStyle(ChartConstant.BAR_GRAPH_STYLE_PERSENTAGE);

	// 【５】折れ線グラフサンプルデータ
	LineGraphInfo lineGraphInfo = new LineGraphInfo();
	LineDataset lineDataset = new LineDataset();

	StandardData lineSeries1 = new StandardData();
	lineSeries1.setName("東京支店");
	lineSeries1.setValues(new Number[] { 300, 200, 250, 300, 360, 390 });

	StandardData lineSeries2 = new StandardData();
	lineSeries2.setName("大阪支店");
	lineSeries2.setValues(new Number[] { 240, 300, 350, 180, 380, 340 });

	lineDataset.setCategory(new String[] { "1月", "２月", "３月", "４月", "５月", "６月" });
	lineDataset.addData(lineSeries1);
	lineDataset.addData(lineSeries2);
	lineGraphInfo.setDataset(lineDataset);

	// 【６】レーダーチャートサンプルデータ
	RadarGraphInfo radarGraphInfo = new RadarGraphInfo();
	RadarDataset radarDataset = new RadarDataset();

	StandardData radarSeries1 = new StandardData();
	radarSeries1.setName("東京支店");
	radarSeries1.setValues(new Number[] { 100, 230, 400, 200, 350, 340 });

	StandardData radarSeries2 = new StandardData();
	radarSeries2.setName("大阪支店");
	radarSeries2.setValues(new Number[] { 240, 490, 190, 300, 350, 180 });

	StandardData radarSeries3 = new StandardData();
	radarSeries3.setName("名古屋支店");
	radarSeries3.setValues(new Number[] { 410, 290, 320, 400, 250, 380 });

	radarDataset.setCategory(new String[] { "1月", "２月", "３月", "４月", "５月", "６月" });
	radarDataset.addData(radarSeries1);
	radarDataset.addData(radarSeries2);
	radarDataset.addData(radarSeries3);
	radarGraphInfo.setDataset(radarDataset);

	// 【７】ポートフォリオ・グラフ用サンプルデータ
	PortFolioGraphInfo portFolioInfo = new PortFolioGraphInfo(50, 6000);
	PortFolioDataset portFolioDataset = new PortFolioDataset();

	PortFolioData pfSeries1 = new PortFolioData();
	pfSeries1.setName("東京");
	pfSeries1.addValue(new PortFolioValue(15, 3000, 1000));
	pfSeries1.addValue(new PortFolioValue(90, 9000, 1000));

	PortFolioData pfSeries2 = new PortFolioData();
	pfSeries2.setName("大阪");
	pfSeries2.addValue(new PortFolioValue(50, 5000, 3000));

	PortFolioData pfSeries3 = new PortFolioData();
	pfSeries3.setName("名古屋");
	pfSeries3.addValue(new PortFolioValue(35, 3000, 2000));

	portFolioDataset.addData(pfSeries1);
	portFolioDataset.addData(pfSeries2);
	portFolioDataset.addData(pfSeries3);

	portFolioInfo.setDataset(portFolioDataset);

	// 【８】複合グラフ
	//棒、折れ線の情報は、[２]と[５]で設定したものをそのまま利用します。

	// 【９】】棒グラフ + 折れ線グラフ（二重Yグラフ）
	//折れ線データ
	LineGraphInfo lineInfo = new LineGraphInfo();
	LineDataset lineData = new LineDataset();
	StandardData lineSeries = new StandardData();
	lineSeries.setName("営業費");
	lineSeries.setValues(new Number[] { 280, 130, 100, 190, 70, 80, 130, 110, 390, 383 });

	lineData.setCategory(new String[] { "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008" });
	lineData.addData(lineSeries);
	lineInfo.setDataset(lineData);

	// 棒データ
	BarGraphInfo barInfo = new BarGraphInfo();
	BarDataset barData = new BarDataset();
	StandardData barSeries = new StandardData();
	barSeries.setName("東京支店");
	barSeries.setValues(new Number[] { 3200, 3600, 4000, 4200, 3940, 4300, 6400, 2320, 3420, 5000 });

	barData.setCategory(new String[] { "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008" });
	barData.addData(barSeries);
	barInfo.setDataset(barData);
	barInfo.setXDataLableAngle(ChartConstant.DATA_LABLE_ANGLE_UP45);
	
%>

<table border="0">
	<tr height="25">
		<td class="toolbar_bg" align="center"><b> １．円グラフ </b></td>
		<td width="20"></td>
		<td class="toolbar_bg" align="center"><b> ２．棒グラフ（一般） </b></td>
		<td width="20"></td>
		<td class="toolbar_bg" align="center"><b> ３．棒グラフ（積上げ） </b></td>
	</tr>
	<tr>
		<!-- 円グラフ -->
		<td>
		<table class="table_border_line">
			<tr>
				<td><imchart:chart style="pie" data="<%=pieGraphInfo %>" imageHeight="330" imageWidth="270"></imchart:chart></td>
			</tr>
		</table>
		</td>
		<td></td>
		<!-- 棒グラフ（一般）-->
		<td>
		<table class="table_border_line">
			<tr>
				<td><imchart:chart style="bar" data="<%=barGraphInfo %>" imageHeight="330" imageWidth="270"></imchart:chart></td>
			</tr>
		</table>
		</td>
		<td></td>
		<!-- 棒グラフ（積上げ） -->
		<td>
		<table class="table_border_line">
			<tr>
				<td><imchart:chart style="bar" data="<%=stackedBarInfo %>" imageHeight="330" imageWidth="270"></imchart:chart></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr height="15">
		<td></td>
	</tr>
	<tr height="25">
		<td class="toolbar_bg" align="center"><b> ４．棒グラフ（100%積上げ）</b></td>
		<td width="20"></td>
		<td class="toolbar_bg" align="center"><b> ５．折れ線グラフ </b></td>
		<td width="20"></td>
		<td class="toolbar_bg" align="center"><b> ６．レーダーグラフ </b></td>
	</tr>
	<tr>
		<!--- 棒グラフ（100%積上げ） --->
		<td>
		<table class="table_border_line">
			<tr>
				<td><imchart:chart  style="bar" data="<%=persentageBarInfo %>" imageHeight="330" imageWidth="270"></imchart:chart></td>
			</tr>
		</table>
		</td>
		<td></td>
		<!--- 折れ線グラフ --->
		<td>
		<table class="table_border_line">
			<tr>
				<td><imchart:chart style="line" data="<%=lineGraphInfo %>" imageHeight="330" imageWidth="270"></imchart:chart></td>
			</tr>
		</table>
		</td>
		<td></td>
		<!--- レーダーグラフ --->
		<td>
		<table class="table_border_line">
			<tr>
				<td><imchart:chart style="radar"
					data="<%=radarGraphInfo %>" imageHeight="330" imageWidth="270"></imchart:chart></td>
			</tr>
		</table>
		</td>
		<td></td>
	</tr>

	<tr height="15">
		<td></td>
	</tr>
	<tr height="25">
		<td class="toolbar_bg" align="center"><b> ７．ポートフォリオグラフ</b></td>
		<td width="20"></td>
		<td class="toolbar_bg" align="center"><b> ８．複合グラフ </b></td>
		<td width="20"></td>
		<td class="toolbar_bg" align="center"><b> ９．棒 + 折れ線グラフ</b></td>
	</tr>
	<tr>
		<!--- ポートフォリオグラフ --->
		<td>
		<table class="table_border_line">
			<tr>
				<td><imchart:chart style="portFolio" data="<%=portFolioInfo %>" imageHeight="330" imageWidth="270"></imchart:chart></td>
			</tr>
		</table>
		</td>
		<td></td>
		<!--- 複合グラフ --->
		<td>
		<table class="table_border_line">
			<tr>
				<td><imchart:chart style="combined" data="<%=barGraphInfo %>"
					subData="<%=lineGraphInfo %>" imageHeight="330" imageWidth="270"></imchart:chart></td>
			</tr>
		</table>
		</td>
		<td></td>
		<!--- 二重Yグラフ --->
		<td>
		<table class="table_border_line">
			<tr>
				<td><imchart:chart style="bar" data="<%=barInfo %>" subData="<%=lineInfo %>" imageHeight="330" imageWidth="270"></imchart:chart></td>
			</tr>
		</table>
		</td>
		<td></td>
	</tr>
</table>
