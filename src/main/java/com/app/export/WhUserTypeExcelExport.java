package com.app.export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;
import com.app.model.WhUserType;

public class WhUserTypeExcelExport extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "Attachement;Filename=WhUserExcelView.xlsx");

		List<WhUserType> wh=(List<WhUserType>) model.get("list");
		Sheet 	sheet=workbook.createSheet();
		setHead(sheet);
		setBody(sheet,wh);

	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("UID");
		row.createCell(1).setCellValue("UTYPE");
		row.createCell(2).setCellValue("UCODE");
		row.createCell(2).setCellValue("UFOR");

		row.createCell(3).setCellValue("EMIL");
		row.createCell(4).setCellValue("CONTACT");
		row.createCell(5).setCellValue("UIDTYPE");
		row.createCell(2).setCellValue("OTHERS");
		row.createCell(2).setCellValue("IDTYPE");


	}

	private void setBody(Sheet sheet, List<WhUserType> list) {
		int rowNum=1;
		for(WhUserType s:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getUid());
			row.createCell(1).setCellValue(s.getUserType());
			row.createCell(2).setCellValue(s.getUserCode());
			row.createCell(3).setCellValue(s.getUserFor());
			row.createCell(4).setCellValue(s.getUserMail());
			row.createCell(5).setCellValue(s.getUserContact());
			row.createCell(5).setCellValue(s.getOtherType());
			row.createCell(5).setCellValue(s.getUserIdType());

		}

	}
}
