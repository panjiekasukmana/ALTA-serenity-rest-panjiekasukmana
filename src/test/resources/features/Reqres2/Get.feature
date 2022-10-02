Feature: Features to test Reqres
  @Latihan
  Scenario Outline: Get list user with parameter
    Given Get list user with parameter page <page>
    When Send request get list user
    Then Should return 200 OK
    And success get list user with page <page>
    And Get list user schema validator
    Examples:
      |page|
      |1   |
      |2   |

  @Tugas
  Scenario Outline: Get list user with invalid parameter
    Given Get list user with parameter page <page>
    When Send request get list user with invalid parameter
    Then Should return 404 not found
    And Response body page should be <page>
    Examples:
      |page|
      |8000   |
      |9000   |

  @Tugas
  Scenario Outline: Get single user
    Given Get single user with id <id>
    When Send request get single user
    Then Should return 200 OK
    And Response body page <id>
    And Get single user schema validator
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas
  Scenario Outline: Get single list resource valid parameter
    Given Get single list resource <id>
    When Send request get list resource
    Then Should return 200 OK
    And Succes get single list resource <id>
    And Get single list resource schema validator
    Examples:
      |id|
      |2 |
      |3 |

  @Tugas
  Scenario Outline: Get single list resource invalid parameter
    Given Get single list resource <id>
    When Send request get list resource
    Then Response 404 not found
    Examples:
      |id|
      |37 |
      |65 |