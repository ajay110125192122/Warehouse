package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UomUtil {

	public void generatePieChart(String path, List<Object[]> list) {
		DefaultPieDataset dataset=new DefaultPieDataset()	;
		for(Object[] d:list) {
			//dataset.setValue(d[0].toString(), d[1].toString());
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));
			JFreeChart chart=ChartFactory.createPieChart3D("UOM", dataset, true, true, false);	
			try {
				ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/UomPieChart.jpg"), chart, 300, 300);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
