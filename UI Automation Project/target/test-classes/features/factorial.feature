@factorial
Feature: The user would be able to calculate the factorial of any integer

  Background: 
    Given I navigate to the factorial calculator page

  @inputBoxTest
  Scenario Outline: The user should be able to calculate the factorial of any integer given as input in the text field
    When The page is loaded I can see the title "Factoriall" of the window
    And The user gives "<input>" in the text field and click on calculate button
    Then I can see the result "<expectedResult>" on the page

    Examples: 
      | input                                                         | expectedResult                                 |
      |                                                             4 | The factorial of 4 is: 24                      |
      |                                                           300 | The factorial of 300 is: 24                    |
      | we                                                            | Please enter an integer                        |
      |                                                           4.5 | Please enter an integer                        |
      |                                                            -3 | The factorial of -3 is: -6                     |
      | @3                                                            | Please enter an integer                        |
      |                                                            03 | The factorial of 03 is: 6                      |
      | 3333333333333333333333333333333333333333333333333333333333333 | Please enter an Integer within specified limit |
      | 3E                                                            | Please enter an integer                        |

  @LinkTest
  Scenario Outline: Checking the navigation of the links present on the page
    When The page is loaded I can see the title "Factoriall" of the window
    And the user clicks on "<linkName>" which navigates to "<linkURL>"
    Then I can see the "<windowTitle>" and "<expectedWindowContent>" for "<linkName>"

    Examples: 
      | linkName             | linkURL                                                                                       | windowTitle                                        | expectedWindowContent                                                                |
      | Terms and Conditions | http://qainterview.pythonanywhere.com/terms                                                   | Terms and Conditions                               | This is the privacy document. We are not yet ready with it. Stay tuned!              |
      | Privacy              | http://qainterview.pythonanywhere.com/privacy                                                 | Privacy                                            | This is the terms and conditions document. We are not yet ready with it. Stay tuned! |
      | Qxf2 Services        | https://qxf2.com/?utm_source=qa-interview&utm_medium=click&utm_campaign=From%20QA%20Interview | Qxf2 Services: Outsourced Software QA for startups | QA for startups                                                                      |

  @PageContentTest
  Scenario: The page should have window title, page title, placeholder for input box and license period
    When The page is loaded I can see the title "Factoriall" of the window
    Then I can see the page title as "The greatest factorial calculator!"
    And I can see the placeholder value as "Enter an integer" in the input box
