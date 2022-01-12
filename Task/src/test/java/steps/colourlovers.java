package steps;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import API.colourloversLogic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class colourlovers {
	
	
	 ArrayList<Integer> NumViews = new ArrayList<Integer>();
	@Given("Get colourlovers")
	public void Getcolourlovers() throws JsonMappingException, JsonProcessingException {
		
		 NumViews=colourloversLogic.GetNumviews();
		
		
	}
	
	@Then("Verify Numviews greater than 4000")
	public void CheckNumViews() {
		
		colourloversLogic.CheckViewNum(NumViews);
		
	}

}
