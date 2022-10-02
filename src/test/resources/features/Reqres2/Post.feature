Feature: reqres feature

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create new user
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "Panji Eka" and job "Junior QA"
    And Create new user schema validator

  @Tugas #Negative
  Scenario: Post create new user with invalid json
    Given Post create new user without job
    When Send request post create new user
    Then Should return 400 bad request
    And Create invalid user schema validator

  @Tugas #Positive
  Scenario: Post register with valid email
    Given Post register with email
    When Send request post register
    Then Should return should be 200 OK
    And Register valid email schema validator

  @Tugas #Negative #Bug
  Scenario: Post register with invalid email
    Given Post register without email
    When Send request post register without email
    Then Should return should be 400 bad request
    And Register without email schema validator

  @Tugas #Negative
  Scenario: Post register with invalid email
    Given Post register without password
    When Send request post register without password
    Then Should return should be 400 bad request
    And Register without password schema validator

  @Tugas #Positive
  Scenario: Post login with valid email
    Given Post login with email
    When Send request login
    Then Status code 200 ok
    And Login with valid email  schema validator

  @Tugas #Bermasalah
  Scenario: Post login without password
    Given Post login without password
    When Send request login without password
    Then Status code 400 bad request
