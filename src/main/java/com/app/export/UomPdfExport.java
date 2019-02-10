package com.app.export;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfExport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		
		//set file name
		response.setHeader("Content-Disposition", "attachment;filename=UOMS.pdf");
		//read model data
		List<Uom> list=(List<Uom>) model.get("list");
		
		//#1 Create any Element
		Paragraph p=new Paragraph("Hello PDF");
		//#2 Add Element to doc
		document.add(p);
		
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("UOMTYPE");
		table.addCell("UOMMODEL");
		table.addCell("UOMDSC");
		
		for(Uom s:list) {
			table.addCell(s.getId().toString());
			table.addCell(s.getUomType().toString());
			table.addCell(s.getUomModel().toString());
			table.addCell(s.getUomDsc().toString());
		}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
		
}


}
