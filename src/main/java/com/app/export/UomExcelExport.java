package com.app.export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelExport  extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "Attachement;Filename=UomExcelView.xlsx");

		List<Uom> list= (List<Uom>) model.get("list");
		Sheet sheet= workbook.createSheet("Uoms");
		setHead(sheet);
		setBody(sheet, list);

	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("UOMTYPE");
		row.createCell(2).setCellValue("UOMMODEL");
		row.createCell(3).setCellValue("UOMDSC");
	}

	private void setBody(Sheet sheet, List<Uom> list) {
		Integer rowNum=1;
		for(Uom uom:list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(uom.getId());
			row.createCell(1).setCellValue(uom.getUomType());
			row.createCell(2).setCellValue(uom.getUomModel());
			row.createCell(3).setCellValue(uom.getUomDsc());
		}

	}

}
