Feature: Validation of PUT request for UserRoleStatus in User Mudule

  Background: Setup Authorization

    Given User sets Authorization to No Auth
   @test-A1-Positive-Valid-URL
   Scenario Outline: Verify PUT request for updating UserRoleStatus in User module  with valid endpoint and mandatory fields
    Given User sets request for updting UserRoleStatus in User module with valid endpoint and mandatory fields
    When User send PUT request with data for UserRoleStatus in User module from "<SheetName>" and <Rownumber>
    Then User successful updated UserRoleStatus in User module with status code 200
 		 
    Examples: 
      | SheetName              | Rownumber |
      | UpdateUserRoleStatus   |         0 |
   
   
   
   @test-A2-Negative-Invalid-URL
    Scenario Outline: Verify PUT request for updating UpdateUserRoleStatus in Usermodule with Invalid endpoint and mandatory fields
    Given User sets request for  updting UserRoleStatus in User module with invalid endpoint 
    When User send PUT request with data for  updating UserRoleStatus in User module from "<SheetName>" and <Rownumber>
    Then User is not successfull  updating UserRoleStatus in User module with status code 404
 		 
    Examples: 
      | SheetName           | Rownumber |
      | UpdateUserRoleStatus   |         0 |
   
   
     @test-A3-Negative-valid-URL-Missing-Payload
    Scenario Outline: Verify put request for  updting UserRoleStatus in User module  with valid endpoint and missing mandatory fields
    Given User sets request for  updting UserRoleStatus in User module with valid endpoint 
    When User send PUT request with data for  updting UserRoleStatus in User module from "<SheetName>" and <Rownumber>
    Then User is not successfull  updating UserRoleStatus in User module with status code 400
 		 
    Examples: 
      | SheetName                     | Rownumber |
      | UpdateUserRoleStatus          |         1 |
   
   
  