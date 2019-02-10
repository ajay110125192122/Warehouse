package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.servie.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {

	@Autowired
	private IDocumentService service;

	//1.showing the uploading page
	@RequestMapping("/show")
	public String showPage(ModelMap map)
	{
		List<Object[]> list=service.getFileIdAndFileName();
		map.addAttribute("list",list);

		return "Document";
	}
	//2. uploading 
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam ("multipartFile") CommonsMultipartFile file , ModelMap map) {
		if(file!=null) {
			//convert CMF data to Model class obj
			Document doc=new Document();
			//doc.setFileId(fileId); auto generated
			doc.setFileName(file.getOriginalFilename());
			doc.setFileData(file.getBytes());
			int id=service.saveDocument(doc);

			map.addAttribute("message", "file uploaded with id="+id);
		}


		List<Object[]> list=service.getFileIdAndFileName();
		map.addAttribute("list",list);
		return "Document";
	}
	//3. on click download
	@RequestMapping("/download")
	public void download(@RequestParam int docId , HttpServletResponse res) {
		Document doc=service.getDocumentById(docId);
		//add header
		res.addHeader("Content-Disposition","attachment;fileName="+doc.getFileName());
		//add body
		try {
			FileCopyUtils.copy(doc.getFileData(),res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

















