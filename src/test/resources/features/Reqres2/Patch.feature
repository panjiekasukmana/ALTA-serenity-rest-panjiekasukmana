Feature: reqres feature

  @Positive
  Scenario Outline: Patch update user with valid json
    Given Patch update user <id>
    When Send request patch update user id
    And Response body contain name "Panji Eka Sukmana" and job "QA Engineer"
    Then Response 200 ok
    And Patch update user schema validator
    Examples:
      |id|
      |1 |
      |2 |


  @Negative
  Scenario Outline: Patch update user with invalid json
    Given Patch update user without job <id>
    When Send request patch update user id invalid json
    Then Response status 200 ok
    And Patch update useer invalid schema validator
    Examples:
      |id|
      |1 |
      |2 |
