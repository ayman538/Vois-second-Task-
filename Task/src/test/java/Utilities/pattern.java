package Utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class pattern {
	
	private int id;
	
	private int numViews;
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumViews() {
		return numViews;
	}

	public void setNumViews(int numViews) {
		this.numViews = numViews;
	}

}


