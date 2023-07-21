Feature: Validation of POST request in Program Module 

Background: Setup Authorization 
	Given User sets Authorization to No Auth 
	
Scenario Outline: Verify POST request with valid endpoint and valid request body 
	Given User sets request for Program module with valid endpoint and valid request body 
	When User send POST request with data from "<SheetName>" and <RowNumber> 
	Then User should get status code "201" for POST request with valid endpoint and valid request body 
	
	Examples: 
		|SheetName				| RowNumber		|
		|ProgramPOSTValidData	|0				|
		
		
	