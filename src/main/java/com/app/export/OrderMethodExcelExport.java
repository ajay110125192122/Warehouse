package com.app.export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelExport extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "Attachment;Filename=OrderMethodView.xlsx");
		List<OrderMethod> list= (List<OrderMethod>) model.get("list");
		//create sheet
		Sheet sheet= workbook.createSheet();
		// set head row-0
		setHead(sheet);
		//set body in loop
		setBody(sheet, list);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ExeType");
		row.createCell(4).setCellValue("Accept");

	}
	private void setBody(Sheet sheet, List<OrderMethod> list) {
		int rowNum=1;
		for(OrderMethod omd:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(omd.getOid().toString());
			row.createCell(1).setCellValue(omd.getOrderMode().toString());
			row.createCell(2).setCellValue(omd.getOrderCode().toString());
			row.createCell(3).setCellValue(omd.getExeType().toString());
			row.createCell(4).setCellValue(omd.getOrderAccept().toString())//.toString()!=null?omd.getOrderAccept().toString():"[]")
					;
		}
	}
}
