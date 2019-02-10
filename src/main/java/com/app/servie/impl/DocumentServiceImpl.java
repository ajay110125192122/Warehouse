package com.app.servie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.servie.IDocumentService;


@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	private IDocumentDao dao;


	@Transactional
	public Integer saveDocument(Document doc) {
		return dao.saveDocument(doc);
	}


	@Transactional
	public List<Document> getAllDOcuments() {
		return dao.getAllDocuments();
	}


	@Transactional(readOnly=true)
	public List<Object[]> getFileIdAndFileName() {
		return dao.getFileIdAndFileName();
	}
@Transactional(readOnly=true)
public Document getDocumentById(int id) {
	return dao.getDocumentById(id);
}
}
