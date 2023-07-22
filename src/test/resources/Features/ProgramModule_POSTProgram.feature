Feature: Validation of POST request in Program Module

  Background: Setup Authorization
    Given User sets Authorization to No Auth

  Scenario: Verify POST request with valid base URL and valid data
    Given User sets request for Program module with base URL with valid endpoint and valid request body
    When User send POST request with data from "<SheetName>" and <RowNumber>
    Then User gets success message with status code "201" in response body

    Examples: 
      | SheetName            | RowNumber |
      | ProgramPOSTValidData |         0 |

  Scenario: Verify POST request to post data into program with invalid base URL and valid data
    Given User sets request for Program module with invalid base URL and valid request body
    When User sends POST request with invalid URL and data from "<SheetName>" and <Rownumber>
    Then User gets Bad Request error message with status code "404" in response body

    Examples: 
      | SheetName              | Rownumber |
      | ProgramPOSTinvalidData |         1 |

  Scenario: Verify POST request to post data into program with valid URL and Blank data fields
    Given User sets request for Program module with valid base URL and valid paramertes in request body
    When User sends POST request with Null values in all mandatory fields in request body
    Then User gets Bad Request error message with status code "400" in response body
    
  Scenario: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request with Null Value programName parameter in request body
    Then User gets Bad Request error message with status code "400" in response body

  Scenario: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request without programDescription parameter in the request body
    Then User gets Bad Request error message with status code "400" in response body

  Scenario Outline: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request with Null value in programDescription parameter from "<SheetName>" and <Rownumber>
    Then User gets Bad Request error message with status code "400" in response body

    Examples: 
      | SheetName              | Rownumber |
      | RequestBodyInvalidData |         1 |

  Scenario Outline: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request without programStatus parameter from "<SheetName>" and <Rownumber>
    Then User gets Bad Request error message with status code "400" in response body

    Examples: 
      | SheetName   | Rownumber |
      | NoProgStaus |         0 |

  Scenario Outline: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request with null value for programStatus parameter from "<SheetName>" and <Rownumber>
    Then User gets Bad Request error message with status code "400" in response body

    Examples: 
      | SheetName              | Rownumber |
      | RequestBodyInvalidData |         0 |

   Scenario: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request with creationTime parameter value as alphanumeric in the request body 
    Then User gets Bad Request error message with status code "400" in response body


  Scenario: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request with creationTime parameter value as special characters in the request body
    Then User gets Bad Request error message with status code "400" in response body
    

  Scenario: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request without lastModTime parameter in the request body
    Then User gets Bad Request error message with status code "400" in response body
    

  Scenario: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request with lastModTime parameter value as an Empty String in the Request body from "<SheetName>" and <Rownumber>
    Then User gets Bad Request error message with status code "400" in response body
    
      Examples: 
      | SheetName              | Rownumber |
      | RequestBodyInvalidData |         0 |

  Scenario: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request with lastModTime parameter value as alphabetnumeric in the request body
    Then User gets Bad Request error message with status code "400" in response body

  Scenario: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST requestwith lastModTime parameter value as special characters in the request body
    Then User gets Bad Request error message with status code "400" in response body

  Scenario: Verify POST request to post data into program with valid base URL and invalid data
    Given User sets request for Program module with valid base URL and invalid data
    When User sends POST request with lastModTime parameter value as Date format from "<SheetName>" and <Rownumber>
    Then User gets Bad Request error message with status code "400" in response body

    Examples: 
      | SheetName         | Rownumber |
      | LastModDateFormat |         0 |
