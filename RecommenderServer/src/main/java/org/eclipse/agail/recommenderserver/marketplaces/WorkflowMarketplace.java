/*********************************************************************
 * Copyright (C) 2017 TUGraz.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/
package org.eclipse.agail.recommenderserver.marketplaces;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.eclipse.agail.recommenderserver.models.App;
import org.eclipse.agail.recommenderserver.models.Workflow;

public class WorkflowMarketplace {
	
	public static List<Workflow> workflowList = new ArrayList<Workflow>();
	public static IndexWriter indexWriter_wfMarketplace;
	public static StandardAnalyzer analyzer_wf;
	public static Directory directoryIndex_wf;
	public static Document doc_wf;
	public static int size = 0;
	
	public static void initiate(){
		doc_wf = new Document();
		analyzer_wf = new StandardAnalyzer();
		// 1. create the index
		directoryIndex_wf = new RAMDirectory();
//		try {
//			directoryIndex_wf = FSDirectory.open(Paths.get("C:\\temp\\index_workflow.lucene"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		IndexWriterConfig config = new IndexWriterConfig(analyzer_wf);
	    try {
	    	indexWriter_wfMarketplace = new IndexWriter(directoryIndex_wf, config);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void addNewWorkFlow(Workflow wf){
		doc_wf = new Document();
		workflowList.add(wf);
		size++;
		doc_wf.add(new StringField("type", wf.getType(), Field.Store.YES));
		doc_wf.add(new TextField("datatag", wf.getDatatag(), Field.Store.YES));
		doc_wf.add(new StringField("dataowner", wf.getDataowner(), Field.Store.YES));
		doc_wf.add(new StringField("href", wf.getHref(), Field.Store.YES));
				
		try {
			indexWriter_wfMarketplace.addDocument(doc_wf);
		} catch (IOException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void stopAddingToMarketplace(){
		try {
			indexWriter_wfMarketplace.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
