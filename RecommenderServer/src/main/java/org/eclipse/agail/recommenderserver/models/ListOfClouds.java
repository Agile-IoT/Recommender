package org.eclipse.agail.recommenderserver.models;

import java.util.ArrayList;
import java.util.List;

public class ListOfClouds {
	
	private List<Cloud> cloudList = new ArrayList<Cloud>();

	public List<Cloud> getCloudList() {
		return cloudList;
	}

	public void setCloudList(List<Cloud> cloudList) {
		this.cloudList = cloudList;
	}

}
