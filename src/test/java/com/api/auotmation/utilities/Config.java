package com.api.auotmation.utilities;

public class Config {
	
	public static final String base_URL="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms";
	public static final String programMod_POST_URL="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/saveprogram";		
	public static final String BatchModule_POST_URL="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/batches";	
	public static final String excelFilePath="./Data Files/API-Phase2-RESTAssuredCucumber-Data.xlsx";
	public static final String assignment_PUT_URL="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/4017";
	public static final String assignment_PUT_Invalid_URL="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments//abc";
	//public static final String excelFilePath="/API.Phase2.RestAssuredCucumber/Data Files/API-Phase2-RESTAssuredCucumber-Data.xlsx";
//	public static final String excelFilePath = ".Data Files/API-Phase2-RESTAssuredCucumber-Data1.xlsx"
	public static final String User_PUT_User_role_status="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/users/users/roleStatus/U9505";
	public static final String User_PUT_User_Role_Program_Batch="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/users/users/roleProgramBatchStatus/U9505";
	public static final String Invalid_User_PUT_User_role_status="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/users/users/roleStatus//U9505a";
	public static final String Invalid_User_PUT_User_Role_Program_Batch="\"https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/users/users/roleProgramBatchStatus//U9505a";
}
