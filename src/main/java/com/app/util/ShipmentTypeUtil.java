package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;
@Component
public class ShipmentTypeUtil {

	public void generatePieChart(String path, List<Object[]> data) {


		//1. creating data set object

		DefaultPieDataset dataset=new DefaultPieDataset();
		for (Object[] d:data) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));

		}
		//2. convert data set to Jfree chart image
		JFreeChart chart=ChartFactory.createPieChart("SHIPMENTS", dataset, true, true, false);
		//3. data convention and save as image
		try {
			//ChartUtils.saveChartAsJPEG(path+"/resources/images/Orders_Pie_Chart.png", chart, 150, 150);
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/OrdersPieChart.jpg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void generateBarCharts(String path, List<Object[]> data) {
		DefaultCategoryDataset dataset= new DefaultCategoryDataset();

		for (Object[] t:data) {
			dataset.setValue(new Double(t[1].toString()), t[0].toString(), path);
		}
		JFreeChart	 chart=	ChartFactory.createBarChart("Shipments", "ShipmentMode", "count", dataset);
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/ShipmentBarReport.jpg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
