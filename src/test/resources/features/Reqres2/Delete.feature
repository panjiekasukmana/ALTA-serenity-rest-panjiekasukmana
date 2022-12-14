Feature: reqres feature

  @Positive
  Scenario Outline: Delete user with valid data
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return 204 No Content
    Examples:
      |id|
      |1 |
      |2 |

  @Positive
  Scenario Outline: Delete user with invalid data
    Given Delete user with invalid id <id>
    When Send request delete user
    Then Response 204 no content
    Examples:
      |id|
      |34 |
      |65 |
