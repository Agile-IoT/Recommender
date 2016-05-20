package at.tugraz.ist.agileRecommender.lucene.workflow;

public class WorkFlow {
	
	public String type;
	public String datatag;
	public String dataowner;
	public String href;
	
	public WorkFlow(){
		
	}
	public WorkFlow(String type,String datatag,String dataowner,String href){
		this.type = type;
		this.datatag = datatag;
		this.dataowner = dataowner; 
		this.href = href;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDatatag() {
		return datatag;
	}
	public void setDatatag(String datatag) {
		this.datatag = datatag;
	}
	public String getDataowner() {
		return dataowner;
	}
	public void setDataowner(String dataowner) {
		this.dataowner = dataowner;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	

}