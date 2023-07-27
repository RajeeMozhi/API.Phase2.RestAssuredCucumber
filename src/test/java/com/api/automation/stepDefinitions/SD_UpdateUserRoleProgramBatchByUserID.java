package com.api.automation.stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;

import com.api.auotmation.utilities.Config;
import com.api.automation.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SD_UpdateUserRoleProgramBatchByUserID extends BaseClass{
	public String UserRoleProgramBatch_uri;
	public RequestSpecification UserRoleProgramBatch_request;
	public Response UserRoleProgramBatch_response;
	
	@Given("User sets request for updating UserRoleProgramBatch in User module with valid endpoint and mandatory fields")
	public void user_sets_request_for_updating_user_role_program_batch_in_user_module_with_valid_endpoint_and_mandatory_fields() {
		this.UserRoleProgramBatch_uri = Config.User_PUT_User_Role_Program_Batch;
		this.UserRoleProgramBatch_request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for updating UserRoleProgramBatch in User module with valid base URL and valid data");
	}

	@When("User send PUT request with data for UserRoleProgramBatch in User module from {string} and {int}")
	public void user_send_put_request_with_data_for_user_role_program_batch_in_user_module_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createPutRequest(SheetName, Rownumber);
		logger.info("Put Request sent with valid request body");
	}

	private void createPutRequest(String sheetName, Integer rownumber) throws InvalidFormatException, IOException {
		String  programId = getDataFromExcel(sheetName, rownumber).get("programId");
		String roleId = getDataFromExcel(sheetName, rownumber).get("roleId");
		  String userId = getDataFromExcel(sheetName, rownumber).get("userId") ;
		   String  batchId = getDataFromExcel(sheetName, rownumber).get("batchId");
		   String userRoleProgramBatchStatus =getDataFromExcel(sheetName, rownumber).get("userRoleProgramBatchStatus");
		   JSONObject body = new JSONObject();
		   body.put("programId", programId);
		   body.put("roleId", roleId);
		   body.put("userId", userId);
		   
		   HashMap<String, String> userRoleProgramBatches = new HashMap<>();
		   userRoleProgramBatches.put("roleId", roleId);
		   userRoleProgramBatches.put("userRoleProgramBatchStatus", userRoleProgramBatchStatus);
		   
		   ArrayList<HashMap<String, String>> jsonArray = new ArrayList<>();
	        jsonArray.add(userRoleProgramBatches);
	        
	        body.put("userRoleProgramBatches", jsonArray);
	        UserRoleProgramBatch_response = this.UserRoleProgramBatch_request
					.body(body.toJSONString())
					.when()
					.put(this.UserRoleProgramBatch_uri)
					.then()
					.log().all().extract().response();
	        UserRoleProgramBatch_response.prettyPrint();
	        
		
	}

	@Then("User successful updated UserRoleProgramBatch in User module with status code {int}")
	public void user_successful_updated_user_role_program_batch_in_user_module_with_status_code(Integer statusCode) {
		
			if (this.UserRoleProgramBatch_response == null) {
		        logger.error("response is null. Please ensure the Put request is executed correctly.");
		        return;
		    }
		
		int Poststatuscode = this.UserRoleProgramBatch_response.getStatusCode();
		if (Poststatuscode == 200) {
			this.UserRoleProgramBatch_response.then().statusCode(statusCode);
			 this.UserRoleProgramBatch_response.then().statusCode(statusCode);
			 UserRoleProgramBatch_response.then().assertThat().header("Connection", "keep-alive");
			 UserRoleProgramBatch_response.then().assertThat().header("Server","Cowboy");
			 UserRoleProgramBatch_response.then().assertThat().header("Content-Type","application/json");
			 UserRoleProgramBatch_response.then().assertThat().header("Transfer-Encoding","chunked");
			logger.info("Put Request Successful");

		}
	}

	@Given("User sets request for  updting UserRoleProgramBatch in User module with invalid endpoint")
	public void user_sets_request_for_updting_user_role_program_batch_in_user_module_with_invalid_endpoint() {
		this.UserRoleProgramBatch_uri = Config.Invalid_User_PUT_User_Role_Program_Batch;
		this.UserRoleProgramBatch_request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for updating UserRoleProgramBatch in User module with invalid base URL and valid data");}

	@When("User send PUT request with data for  updating UserRoleProgramBatch in User module from {string} and {int}")
	public void user_send_put_request_with_missing_data_for_updating_user_role_program_batch_in_user_module_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createPutRequest(SheetName, Rownumber);
		logger.info("Put Request sent with missing");
	}

	@Then("User is not successfull  updating UserRoleProgramBatch in User module with status code {int}")
	public void user_is_not_successfull_updating_user_role_program_batch_in_user_module_with_status_code(Integer statusCode) {
		if (this.UserRoleProgramBatch_response == null) {
	        logger.error("response is null. Please ensure the Put request is executed correctly.");
	        return;
	    }
	
	int Poststatuscode = this.UserRoleProgramBatch_response.getStatusCode();
	 if (Poststatuscode == 404) {
		this.UserRoleProgramBatch_response.then().statusCode(statusCode);
		logger.info("Put Request UnSuccessful");
	}
	else if (Poststatuscode == 400) {
		this.UserRoleProgramBatch_response.then().statusCode(statusCode);
		logger.info("Bad Request");
	}
	 this.UserRoleProgramBatch_response.then().statusCode(statusCode);
	 UserRoleProgramBatch_response.then().assertThat().header("Connection", "keep-alive");
	 UserRoleProgramBatch_response.then().assertThat().header("Server","Cowboy");
	 UserRoleProgramBatch_response.then().assertThat().header("Content-Type","application/json");
	 UserRoleProgramBatch_response.then().assertThat().header("Transfer-Encoding","chunked");
	}

	@Given("User sets request for  updating UserRoleProgramBatch in User module with valid endpoint")
	public void user_sets_request_for_updating_user_role_program_batch_in_user_module_with_valid_endpoint() {
		this.UserRoleProgramBatch_uri = Config.User_PUT_User_Role_Program_Batch;
		this.UserRoleProgramBatch_request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for updating UserRoleProgramBatch in User module with valid base URL and Missing data");
	}

}
