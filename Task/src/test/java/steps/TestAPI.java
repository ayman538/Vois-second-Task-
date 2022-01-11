package steps;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Utilities.API;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TestAPI {
	
	
	 ArrayList<Integer> NumViews = new ArrayList<Integer>();
	@Given("Get colourlovers")
	public void Getcolourlovers() throws JsonMappingException, JsonProcessingException {
		
		 NumViews=API.GetNumviews();
		
		
	}
	
	@Then("Verify Numviews greater than 4000")
	public void CheckNumViews() {
		
		API.CheckViewNum(NumViews);
		
	}

}
