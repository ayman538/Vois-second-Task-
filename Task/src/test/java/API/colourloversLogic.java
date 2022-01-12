package API;


import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import Utilities.pattern;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class colourloversLogic {
	static int expectedViewsNum=4000;

	public static ArrayList<Integer> GetNumviews() throws JsonMappingException, JsonProcessingException {

		RestAssured.baseURI= "http://www.colourlovers.com/api/patterns";
		RequestSpecification request=RestAssured.given();
		request.header("User-Agent", "PostmanRuntime/7.28.4");
		Response response = request.get();
		ResponseBody body=response.getBody();
		System.out.println(body.asString());
		
		String XmlResponse=body.asString();

		XmlMapper mapper = new XmlMapper();


		ArrayList<pattern> PatternList = mapper.readValue(XmlResponse, new TypeReference<ArrayList<pattern>>() {});
		ArrayList<Integer> NumViews = new ArrayList<Integer>();

		for (int i = 1; i < PatternList.size(); i++) {


			System.out.println( PatternList.get(i).getNumViews());
			NumViews.add(PatternList.get(i).getNumViews());




		}
	
		return NumViews;

	}

	

	public static void CheckViewNum(ArrayList<Integer> NumList) {

		for (int i = 1; i < NumList.size(); i++) {

			assertTrue(NumList.get(i)> expectedViewsNum);

		}
	}
}
	
	
	




