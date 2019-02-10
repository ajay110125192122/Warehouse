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
public class OrderMethodUtil {


	public void generatePieChart(String path, List<Object[]> data)
	{
		//1. creating data set object

		DefaultPieDataset dataset=new DefaultPieDataset();
		for (Object[] d:data) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));

		}
		//2. convert data set to Jfree chart image
		JFreeChart chart=ChartFactory.createPieChart("ORDERS", dataset, true, true, false);
		//3. data convention and save as image
		try {
			//ChartUtils.saveChartAsJPEG(path+"/resoueces/images/Orders_Pie_Chart.png", chart, 150, 150);
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/OrdersPieChart.jpg"), chart, 150, 150);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void generateBar(String path , List<Object[]> data) {

		//1. create object
		DefaultCategoryDataset dataset= new DefaultCategoryDataset();
		for(Object[] d:data) {
			dataset.setValue(new Double(d[1].toString()), d[0].toString(), "");
		}
		JFreeChart chart= ChartFactory.createBarChart("Orders", "OrderMode", "count", dataset );

		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/OrdersBarChart.jpg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
