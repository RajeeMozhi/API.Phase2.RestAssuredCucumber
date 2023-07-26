package com.api.auotmation.utilities;

public class Config {
	
	public static final String Base_Valid_URL="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms";
	public static final String Base_Invalid_URL="https://lms-api-hackathon-2023-930a8b0f895d.herokuapp.com/lms";
	
	public static final String programMod_POST_URL="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/saveprogram";		
	
	public static final String GetAllUsers_valid_endpoint="/users/users";
	public static final String GetAllUsers_invalid_endpoint="/user/users";
		
	public static final String GetUserByID_valid_endpoint="/users/users/";
	public static final String GetUserByID_invalid_endpoint="/user/users/";
	
	public static final String GetAllUsersWithRoles_valid_endpoint="/users/users/roles";
	public static final String GetAllUsersWithRoles_invalid_endpoint="/user/users/roles";
	
	public static final String GetAllStaff_valid_endpoint="/users/users/getAllStaff";
	public static final String GetAllStaff_invalid_endpoint="/user/users/getAllStaff";
	
	public static final String PostAssignment_valid_endpoint="/assignments";
	public static final String PostAssignment_invalid_endpoint="/assignment";
	
	
	public static final String excelFilePath="./Data Files/API-Phase2-RESTAssuredCucumber-Data.xlsx";
	

	
	
	
	
	
	//public static final String excelFilePath="/API.Phase2.RestAssuredCucumber/Data Files/API-Phase2-RESTAssuredCucumber-Data.xlsx";
	//public static final String DeleteProgram_URL = "https://lms-backend-service.herokuapp.com/lms/deletebyprogid";

}
