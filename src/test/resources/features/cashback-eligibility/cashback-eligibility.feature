@eligibility
Feature: cashback eligibility

  Scenario Outline: less than 10 transactions
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    And I set the transactions
      | Count | Amount |
      | 1     | 10.5   |
      | 2     | 12.75  |
      | 3     | 5.0    |
      | 4     | 1.5    |
      | 5     | 5.0    |
      | 6     | 100.55 |
      | 7     | 50.1   |
      | 8     | 50.0   |
      | 9     | 49.99  |
    And I count the transactions eligible for cashback
    Then the transactions count should be <expected>

    Examples:
      | year | expected |
      | 2021 | 0        |
      | 2022 | 2        |

  Scenario Outline: greater than 10 transactions
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    And I set the transactions
      | Count | Amount |
      | 1     | 10.5   |
      | 2     | 12.75  |
      | 3     | 5.0    |
      | 4     | 1.5    |
      | 5     | 5.0    |
      | 6     | 100.55 |
      | 7     | 50.1   |
      | 8     | 50.0   |
      | 9     | 49.99  |
      | 10    | 49.0   |
      | 11    | 50.1   |
    And I count the transactions eligible for cashback
    Then the transactions count should be <expected>

    Examples:
      | year | expected |
      | 2021 | 0        |
      | 2022 | 3        |

  Scenario Outline: equal to 10 transactions
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    And I set the transactions
      | Count | Amount |
      | 1     | 10.5   |
      | 2     | 12.75  |
      | 3     | 5.0    |
      | 4     | 1.5    |
      | 5     | 5.0    |
      | 6     | 100.55 |
      | 7     | 50.1   |
      | 8     | 50.0   |
      | 9     | 49.99  |
      | 10    | 50.1   |
    And I count the transactions eligible for cashback
    Then the transactions count should be <expected>

    Examples:
      | year | expected |
      | 2021 | 0        |
      | 2022 | 3        |

  Scenario Outline: 0 transactions
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    And I set the transactions
      | Count | Amount |
      | 0     | 0.0    |
    And I count the transactions eligible for cashback
    Then the transactions count should be <expected>

    Examples:
      | year | expected |
      | 2022 | 0        |