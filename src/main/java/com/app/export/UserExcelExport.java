package com.app.export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.User;

public class UserExcelExport  extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//reading data from model
		response.setHeader("Content-Disposition", "Attachement;Filename=USERS.xlsx");
		List<User> list= (List<User>) model.get("list");
		//create sheet
		Sheet sheet= workbook.createSheet("Users");
		// set head row-0
		setHead(sheet);
		//set body in loop
		setBody(sheet, list);
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("MAIL");
		row.createCell(3).setCellValue("PASSEORD");
		row.createCell(4).setCellValue("CONTACT");
		row.createCell(5).setCellValue("ROLES");
	}

	private void setBody(Sheet sheet, List<User> list) {
		int rowNum=1;
		for(User s:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getUserid());
			row.createCell(1).setCellValue(s.getUserName().toString());
			row.createCell(2).setCellValue(s.getUserMail().toString());
			row.createCell(3).setCellValue(s.getPwd().toString());
			row.createCell(4).setCellValue(s.getMobile().toString());
			row.createCell(5).setCellValue(s.getRoles().toString());
		}
	}

}


