package com.app.export;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfExport extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		
		//set file name
		response.setHeader("Content-Disposition", "attachment;filename=WHUSER.pdf");
		//read model data
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		
		//#1 Create any Element
		Paragraph p=new Paragraph("Hello PDF");
		//#2 Add Element to doc
		document.add(p);
		
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("CODE");
		table.addCell("U-FOR");
		table.addCell("U_MAIL");
		table.addCell("CONTACT");
		table.addCell("ID-TYPE");
		table.addCell("OTHERS");
		table.addCell("IDNUMBER");
	
		for(WhUserType s:list) {
			table.addCell(s.getUid().toString());
			table.addCell(s.getUserType());
			table.addCell(s.getUserCode());
			table.addCell(s.getUserFor());
			table.addCell(s.getUserMail());
			table.addCell(s.getUserContact());
			table.addCell(s.getUserIdType());
			table.addCell(s.getOtherType());
			table.addCell(s.getIdNumber());

		}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
		
}

}
