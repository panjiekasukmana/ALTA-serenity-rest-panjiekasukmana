Feature: reqres feature

  @Positive
  Scenario Outline: Put update user with valid json
    Given Put update user id <id>
    When Send request put update user id
    And Response body should be contain name "Panji Eka" and job "Quality Assurance"
    Then Should return 200 ok
    And Put update user schema validator
    Examples:
      |id|
      |1 |
      |2 |


  @Negative
  Scenario Outline: Put update user with invalid json
    Given Put update user invalid json <id>
    When Send request put update user id invalid json
    Then Return status 200 ok
    And Put update useer invalid schema validator
    Examples:
      |id|
      |1 |
      |2 |
