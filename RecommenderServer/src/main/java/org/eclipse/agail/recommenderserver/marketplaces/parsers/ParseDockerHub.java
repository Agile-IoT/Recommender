/*******************************************************************************
 * Copyright (C) 2017 TUGraz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TUGraz - initial API and implementation
 ******************************************************************************/

package org.eclipse.agail.recommenderserver.marketplaces.parsers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

import org.eclipse.agail.recommenderserver.marketplaces.AppMarketplace;
import org.eclipse.agail.recommenderserver.models.App;

public class ParseDockerHub {

//	  public static void main(String[] args) {
//	    ParserGetter kit = new ParserGetter();
//	    HTMLEditorKit.Parser parser = kit.getParser();
//	    HTMLEditorKit.ParserCallback callback = new ReportAttributes_app();
//
//	    try {
//	      URL u = new URL("https://play.google.com/store/apps?hl=en");
//	      InputStream in = u.openStream();
//	      InputStreamReader r = new InputStreamReader(in);
//	      parser.parse(r, callback, false);
//	    } catch (IOException e) {
//	      System.err.println(e);
//	    }
//	  }
	  
	  public static boolean flag_ResultNotFound = false;
	  
	  public static void getAppList() {
		  	flag_ResultNotFound= false;
		  	AppMarketplace.appList.clear();
		    ParserGetter kit = new ParserGetter();
		    HTMLEditorKit.Parser parser = kit.getParser();
		    HTMLEditorKit.ParserCallback callback = new ReportAttributes_app2();
		    
		   
		    int pageNumber = 1;
		    int size = AppMarketplace.appList.size();
		    
		    while(!flag_ResultNotFound){
			    try {
			    	String u = "https://hub.docker.com/search/?isAutomated=0&isOfficial=0&page="+pageNumber+"&pullCount=0&q=iot&starCount=0";
//			    	//String url = "https://hub.docker.com/u/agileiot/?page="+pageNumber;
//			    	//url = url.replaceAll("REPLACE", "iot");
//				    URL u = new URL(url);
//				    InputStream in = u.openStream();
//				    InputStreamReader r = new InputStreamReader(in);
//				    parser.parse(r, callback, false);
//				    
				    URL url=new URL(u);
			           
		   	        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		   	        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		            con.connect();
			         
				    InputStreamReader r = new InputStreamReader(con.getInputStream());
				    parser.parse(r, callback, false);
				    
			    } catch (IOException e) {
			      System.err.println(e);
			      flag_ResultNotFound = true;
			    }
			    pageNumber++;
			    if(size == AppMarketplace.appList.size())
			    	flag_ResultNotFound = true;
			    else
			    	size =AppMarketplace.appList.size();
			    
			   //  flag_ResultNotFound = true;
		    }
		   
	  }

	}
	class ReportAttributes_app2 extends HTMLEditorKit.ParserCallback {

	  App appToBeAdded = null;
		
	  public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
	     this.listAttributes(attributes);
	  }

	  private void listAttributes(AttributeSet attributes) {
		
	    Enumeration e = attributes.getAttributeNames();
	    int size = 0;
	    
	    while (e.hasMoreElements()) {
	      size = AppMarketplace.appList.size();
	      Object name = e.nextElement();
	      Object value = attributes.getAttribute(name);
	   
		  if(value.toString().contains("RepositoryListItem__flexible") ){
			  appToBeAdded = new App(null,null,-1,-1);
		  }
			 
		  
		  if(appToBeAdded!=null){ 
			  if(name.toString().contains("href")){
				  appToBeAdded.setHref("https://hub.docker.com"+value.toString());
				  appToBeAdded.setTitle(value.toString().replaceAll("/r/", ""));
				  
			  }
			  if(value.toString().contains("RepositoryListItem__value")){
				  if(appToBeAdded.getStars()==-1)
					  appToBeAdded.setStars(0);
				  else if(appToBeAdded.getDownloads()==-1){
					  appToBeAdded.setDownloads(0);
					  AppMarketplace.addNewApp(appToBeAdded);
				  	  System.out.println("App #"+(size+1)+ " = Title:" + appToBeAdded.getTitle()+ ", Href:" + appToBeAdded.getHref()+ ", Stars:" + appToBeAdded.getStars()+ ", Downloads:" + appToBeAdded.getDownloads());
				  	  appToBeAdded = null;
				  }
				  
			  }
		  }
		
	    }
	    
	  }

	  public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
	    this.listAttributes(attributes);
	  }
	}

//	class ParserGetter extends HTMLEditorKit {
//	  public HTMLEditorKit.Parser getParser() {
//	    return super.getParser();
//	  }
//	}
