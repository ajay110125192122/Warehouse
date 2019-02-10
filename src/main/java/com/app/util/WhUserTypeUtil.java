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
public class WhUserTypeUtil {

	public void generatePieChart(String path, List<Object[]> list) {


		DefaultPieDataset dataset=new DefaultPieDataset();
		//dataset.setValue(path, new Double());
		for (Object[] d:list) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString())  );

		}
		JFreeChart chart= ChartFactory.createPieChart3D("WhUserTypes", dataset, true, true, false);

		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/WhUserTypePieReport.jpg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

