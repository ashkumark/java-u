@processing
Feature: cashback processing

  Scenario Outline: less than 10 transactions - cashback is processed correctly at standard rate of 1%
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    Given I set the transactions
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
    When I process cashback amount
    Then the cashback amount should be <expected>

    Examples:
      | year | expected |
      | 2022 | 1.51     |

  Scenario Outline: greater than 10 transactions - cashback is processed correctly at enhanced rate of 2%
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    Given I set the transactions
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
    When I process cashback amount
    Then the cashback amount should be <expected>

    Examples:
      | year | expected |
      | 2022 | 4.02     |

  Scenario Outline: equal to 10 transactions - cashback is processed correctly at standard rate of 1%
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    Given I set the transactions
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
    When I process cashback amount
    Then the cashback amount should be <expected>

    Examples:
      | year | expected |
      | 2022 | 2.01     |

  Scenario Outline: equal to 10 transactions & noTransactionsGreaterThan50 - cashback is processed correctly as £0
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    Given I set the transactions
      | Count | Amount |
      | 1     | 10.5   |
      | 2     | 12.75  |
      | 3     | 5.0    |
      | 4     | 1.5    |
      | 5     | 5.0    |
      | 6     | 10.55  |
      | 7     | 5.1    |
      | 8     | 50.0   |
      | 9     | 49.99  |
      | 10    | 5.1    |
    When I process cashback amount
    Then the cashback amount should be <expected>

    Examples:
      | year | expected |
      | 2022 | 0.00     |

  Scenario Outline: equal to 0 transactions - cashback is processed correctly as £0
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    Given I set the transactions
      | Count | Amount |
      | 0     | 0.0    |
    When I process cashback amount
    Then the cashback amount should be <expected>

    Examples:
      | year | expected |
      | 2022 | 0.00     |

  Scenario Outline: customer joined in 2021 - cashback is processed correctly as £0
    Given the CustomerRegisteredYear <year>
    When I apply the business rules
    Given I set the transactions
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
    When I process cashback amount
    Then the cashback amount should be <expected>

    Examples:
      | year | expected |
      | 2021 | 0.00     |

