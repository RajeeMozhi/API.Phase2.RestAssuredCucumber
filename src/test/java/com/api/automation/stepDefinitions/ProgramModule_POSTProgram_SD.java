package com.api.automation.stepDefinitions;

import com.api.auotmation.utilities.Config;
import com.api.automation.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;

public class ProgramModule_POSTProgram_SD extends BaseClass{
	
	
	String uri;
	public RequestSpecification request;
	Response response;
	
	@Given("User sets Authorization to No Auth")
	public void user_sets_authorization_to_no_auth() {
	 	RestAssured.given().auth().none();
		logger.info("Authorization is set as No Auth");
	}
	
	@Given("User sets request for Program module with valid endpoint and valid request body")
	public void user_sets_request_for_program_module_with_valid_endpoint_and_valid_request_body() {
		this.uri = Config.programMod_POST_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for Program module with valid base URL and valid data");
	}

	@When("User send POST request with data from {string} and {int}")
	public void user_send_post_request_with_data_from_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		createPostRequest(SheetName,RowNumber);   
		logger.info("Post Request sent with valid request body");
	}

	@Then("User should get status code {string} for POST request with valid endpoint and valid request body")
	public void user_should_get_status_code_for_post_request_with_valid_endpoint_and_valid_request_body(String statusCode) {
		
		int Poststatuscode = response.getStatusCode();
		if (Poststatuscode == 201) {
		response.then().statusCode(Integer.parseInt(statusCode));
		logger.info("Post Request Successful");
		
		//use delete request to delete the posted data//
		/*JsonPath js = response.jsonPath();
		int programId = js.getInt("programId");
		response = this.request
				.when()
				.delete(Config.DeleteProgram_URL + "/" + programId)
				.then()
				.log().all().extract().response(); */
	}
	
	else 
		logger.info("Post Request unsuccessful with status code " + statusCode);
	  
	}
	
	
	// Common method for POST request
	@SuppressWarnings("unchecked")
	public void createPostRequest(String SheetName, int Rownumber) throws InvalidFormatException, IOException {
		String programName = DynamicprogName();
		String programDescription = getDataFromExcel(SheetName,Rownumber).get("programDescription");
		String programStatus = getDataFromExcel(SheetName,Rownumber).get("programStatus");
		String creationTime = Timestamp();
		String lastModTime = Timestamp();

		JSONObject body = new JSONObject();
		body.put("programName", programName);
		body.put("programDescription", programDescription);
		body.put("programStatus", programStatus);
		body.put("creationTime", creationTime);
		body.put("lastModTime", lastModTime);
		
		response = this.request
				.body(body.toJSONString())
				.when()
				.post(this.uri)
				.then()
				.log().all().extract().response();	
	}
	


}
