package com.app.export;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfExport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {

		//set file name
		response.setHeader("Content-Disposition", "attachment;filename=SHIPMENTS.pdf");
		//read model data
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");

		//#1 Create any Element
		Paragraph p=new Paragraph("Hello PDF");
		//#2 Add Element to doc
		document.add(p);

		PdfPTable table=new PdfPTable(7);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("ETYPE");
		table.addCell("SDSC");

		for(OrderMethod s:list) {
			table.addCell(s.getOid().toString());
			table.addCell(s.getOrderMode().toString());
			table.addCell(s.getOrderCode().toString());
			table.addCell(s.getExeType().toString());
			table.addCell(s.getsDsc().toString());
		}

		document.add(table);

		//Display generated Date
		document.add(new Paragraph(new Date().toString()));


	}

}
