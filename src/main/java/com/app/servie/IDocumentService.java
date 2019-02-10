package com.app.servie;

import java.util.List;

import com.app.model.Document;

public interface IDocumentService {
	public Integer saveDocument(Document doc);
	public List<Document> getAllDOcuments();
	public List<Object[]> getFileIdAndFileName();
	public Document getDocumentById(int id);
}
