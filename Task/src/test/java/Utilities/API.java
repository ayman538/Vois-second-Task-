package Utilities;


import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import io.restassured.http.ContentType;

public class API {
	static int expectedViewsNum=4000;

	public static ArrayList<Integer> GetNumviews() throws JsonMappingException, JsonProcessingException {

		RestAssured.baseURI= "http://www.colourlovers.com/api/patterns";
		RequestSpecification request=RestAssured.given();
		request.header("User-Agent", "PostmanRuntime/7.28.4");
		Response response = request.get();
		ResponseBody body=response.getBody();
		System.out.println(body.asString());

		XmlMapper mapper = new XmlMapper();


		ArrayList<pattern> val = mapper.readValue(body.asString(), new TypeReference<ArrayList<pattern>>() {});
		ArrayList<Integer> NumViews = new ArrayList<Integer>();

		for (int i = 1; i < val.size(); i++) {


			System.out.println( val.get(i).numViews);
			NumViews.add(val.get(i).numViews);




		}
		System.out.println(NumViews.get(3));
		return NumViews;

	}

	

	public static void CheckViewNum(ArrayList<Integer> NumList) {

		for (int i = 1; i < NumList.size(); i++) {

			assertTrue(NumList.get(i)> expectedViewsNum);

		}
	}

	}




