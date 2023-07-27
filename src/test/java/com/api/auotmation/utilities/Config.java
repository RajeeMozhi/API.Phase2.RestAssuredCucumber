package com.api.auotmation.utilities;

public class Config {
	
	public static final String base_URL="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms";
	public static final String programMod_POST_URL="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/saveprogram";		
	public static final String excelFilePath="./Data Files/API-Phase2-RESTAssuredCucumber-Data.xlsx";
	//public static final String excelFilePath="/API.Phase2.RestAssuredCucumber/Data Files/API-Phase2-RESTAssuredCucumber-Data.xlsx";
	//public static final String DeleteProgram_URL = "https://lms-backend-service.herokuapp.com/lms/deletebyprogid";
   public static final String BATCHMOD_DELETE_URL =base_URL + "/batches/{batchId}";
   public static final String USERMOD_DELETE_URL=base_URL+"/users/users/{userId}";
   public static final String SUBMISSIONMOD_GET_URL=base_URL+"/assignmentsubmission";
   public static final String SUBMISSIONMOD_GETGRADE_ASSIGNMENTID=base_URL+"/assignmentsubmission/getGrades/{assignmentId}";
   public static final String SUBMISSIONMOD_GETGRADE_STUDENTID=base_URL+"/assignmentsubmission/getGradesByStudentId/{studentID}";
   public static final String SUBMISSIONMOD__GETSUBMISSION_BATCHID=base_URL+"/assignmentsubmission/grades/{batchID}";
   public static final String SUBMISSIONMOD_GETSUBMISSION_USERID=base_URL+"/assignmentsubmission/student/{userId}";
}
