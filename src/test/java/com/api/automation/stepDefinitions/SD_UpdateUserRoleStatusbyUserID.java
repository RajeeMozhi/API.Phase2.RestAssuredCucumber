package com.api.automation.stepDefinitions;

import java.io.IOException;

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

public class SD_UpdateUserRoleStatusbyUserID extends BaseClass {
	
	public String UserRoleStatus_uri;
	public RequestSpecification UserRoleStatus_request;
	public Response UserRoleStatus_response;
	
	@Given("User sets request for updating UserRoleStatus in User module with valid endpoint and mandatory fields")
	public void user_sets_request_for_updting_user_role_status_in_user_module_with_valid_endpoint_and_mandatory_fields() {
		this.UserRoleStatus_uri = Config.User_PUT_User_role_status;
		this.UserRoleStatus_request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for updating UserRoleStatus in User module with valid base URL and valid data");
	}

	@When("User send PUT request with data for UserRoleStatus in User module from {string} and {int}")
	public void user_send_put_request_with_data_for_user_role_status_in_user_module_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createPutRequest(SheetName, Rownumber);
		logger.info("Put Request sent with valid request body");
	}

	private void createPutRequest(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		String  roleId = getDataFromExcel(SheetName, Rownumber).get("roleId");
		String userRoleStatus = getDataFromExcel(SheetName, Rownumber).get("userRoleStatus");
		 JSONObject userRoleStatus_body = new JSONObject();
		 userRoleStatus_body.put("roleId", roleId);
		 userRoleStatus_body.put("userRoleStatus", userRoleStatus);
		 UserRoleStatus_response = this.UserRoleStatus_request.body(userRoleStatus_body.toJSONString()).when().put(this.UserRoleStatus_uri).then().log().all().
				  extract().response();
		 UserRoleStatus_response.prettyPrint();
		
	}

	@Then("User successful updated UserRoleStatus in User module with status code {int}")
	public void user_successful_updated_user_role_status_in_user_module_with_status_code(Integer statusCode) {
		if (this.UserRoleStatus_response == null) {
	        logger.error("response is null. Please ensure the Put request is executed correctly.");
	        return;
	    }
	
	int Poststatuscode = this.UserRoleStatus_response.getStatusCode();
	if (Poststatuscode == 200) {
		this.UserRoleStatus_response.then().statusCode(statusCode);
		UserRoleStatus_response.then().assertThat().header("Connection", "keep-alive");
		UserRoleStatus_response.then().assertThat().header("Server","Cowboy");
		UserRoleStatus_response.then().assertThat().header("Content-Type","application/json");
		UserRoleStatus_response.then().assertThat().header("Transfer-Encoding","chunked");
		logger.info("Put Request Successful");

	}
	}

	@Given("User sets request for  updting UserRoleStatus in User module with invalid endpoint")
	public void user_sets_request_for_updting_user_role_status_in_user_module_with_invalid_endpoint() {
		this.UserRoleStatus_uri = Config.Invalid_User_PUT_User_role_status;
		this.UserRoleStatus_request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for updating UserRoleStatus in User module with invalid base URL and valid data");
	   
	}

	@When("User send PUT request with data for  updating UserRoleStatus in User module from {string} and {int}")
	public void user_send_put_request_with_data_for_updating_user_role_status_in_user_module_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createPutRequest(SheetName, Rownumber);
		logger.info("Put Request sent with valid request body");
	}

	@Then("User is not successfull  updating UserRoleStatus in User module with status code {int}")
	public void user_is_not_successfull_updating_user_role_status_in_user_module_with_status_code(Integer statusCode) {
		if (this.UserRoleStatus_response == null) {
	        logger.error("response is null. Please ensure the Put request is executed correctly.");
	        this.UserRoleStatus_response.then().statusCode(statusCode);
			UserRoleStatus_response.then().assertThat().header("Connection", "keep-alive");
			UserRoleStatus_response.then().assertThat().header("Server","Cowboy");
			UserRoleStatus_response.then().assertThat().header("Content-Type","application/json");
			UserRoleStatus_response.then().assertThat().header("Transfer-Encoding","chunked");
	        return;
	    }
	
	int Poststatuscode = this.UserRoleStatus_response.getStatusCode();
	 if (Poststatuscode == 404) {
		this.UserRoleStatus_response.then().statusCode(statusCode);
		logger.info("Put Request UnSuccessful");
	}
	else if (Poststatuscode == 400) {
		this.UserRoleStatus_response.then().statusCode(statusCode);
		logger.info("Bad Request");
	}
	}
	@Given("User sets request for  updting UserRoleStatus in User module with valid endpoint")
	public void user_sets_request_for_updting_user_role_status_in_user_module_with_valid_endpoint() {
		this.UserRoleStatus_uri = Config.User_PUT_User_role_status;
		this.UserRoleStatus_request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for updating UserRoleStatus in User module with valid base URL and valid data");
	}

	@When("User send PUT request with data for  updting UserRoleStatus in User module from {string} and {int}")
	public void user_send_put_request_with_data_for_updting_user_role_status_in_user_module_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createPutRequest(SheetName, Rownumber);
		logger.info("Put Request sent with invalid request body");
	}

}
