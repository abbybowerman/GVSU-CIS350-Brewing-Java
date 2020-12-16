# Overview

The purpose of this updated SRS is to layout the additional functional and non-functional requirments that we have added to complete our app. This document will describe functions that the app already contains and that are in the progress of being finished to ensure an optimal interaction with the app for users. Additionally, this document will explain our approach and use of various testing methods within the project. 

## Functional Requirements

### Login Menu
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR1 | Shall search for user's entered username from database to check if valid | TC9 |
| FR2 | Shall search for user's entered password from database to check if valid | TC9 |
| FR3 | The login button shall take the user to the home screen if user's information is valid | TBD |
| FR4 | Users shall not be directed to the homescreen if the username and password provided are not valid | TC1 |
| FR5 | The sign up button shall take the user to the create account screen| TBD |
| FR6 | Shall require a username and password with each login | TC1 |


### Sign-up Menu
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR7 | Shall determine if the entered username meets all requirements | TC2, TC3, TC4 |
| FR8 | Shall determine if the entered password meets all requirements (at least 8 characters, 1 letter, 1 number, and 1 special character) | TC2, TC3, TC4 |
| FR9 | Shall determine if the re-entered password and original passwords match | TC4 |
| FR10 | The user's information should be entered into the database after signing up | TBD |
| FR11 | The user shall not choose the same username as another registered user | TBD |


### Home Screen
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR12 | The counter shall track how many games users have played | TC5 |
| FR13 | The play button shall take users to the game screen | TBD |
| FR14 | The profile button shall take users to their profile page | TBD |
| FR15 | The search function shall look up users in the database by username | TC6, TC7 |
| FR16 | The logout button shall take users back to the login screen | TC8 |


### Game Function
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR17 | The buttons shall be able to navigate left to dislike and right to like a item | TBD |
| FR18 | If an item is disliked the item shall be removed from the array list | TBD |
| FR19 | If an item is liked it should be kept in the array list | TBD |
| FR20 | The array list shall not have less than 1 item in the list | TBD |
| FR21 | The item shall be displayed and changed as users play the game | TC10 |


## Non-Functional Requirements

### Layout
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR1 | < Non-Functional Requirement 1> | TBD |
| NFR2 | < Non-Functional Requirement 2> | TBD |
| NFR3 | < Non-Functional Requirement 3> | TBD |
| NFR4 | < Non-Functional Requirement 2> | TBD |
| NFR5 | < Non-Functional Requirement 3> | TBD |

### Storage
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR6 | < Non-Functional Requirement 1> | TBD |
| NFR7 | < Non-Functional Requirement 2> | TBD |
| NFR8 | < Non-Functional Requirement 3> | TBD |
| NFR9 | < Non-Functional Requirement 2> | TBD |
| NFR10 | < Non-Functional Requirement 3> | TBD |

### Security
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR11 | < Non-Functional Requirement 1> | TBD |
| NFR12 | < Non-Functional Requirement 2> | TBD |
| NFR13 | < Non-Functional Requirement 3> | TBD |
| NFR14 | < Non-Functional Requirement 2> | TBD |
| NFR15 | < Non-Functional Requirement 3> | TBD |


# Test Specification
The purpose of this section is to list our unit tests, integration tests and system tests. Each category is then further broken down into a description, steps, input values, actual versus expected ouptut values, whether the test passed or failed, and a requirements ID that links together the requirement with its test case. 

## Unit tests
| ID | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------:| :----------: | :----------: | :----------: |
| TC1 | Require a username and password with each login | Attempt to login without credentials | empty strings in username and password | Toast saying invalid username/password | <actual output of test case> | <did it pass or fail?> | FR4, FR6 |
| TC2 | User has valid username but invalid password | create a valid username and an invalid password | valid string for username, invalid string for password | Toast saying Password must contain 1 uppercase, 1 letter, 1 number and 1 special character | <actual output of test case> | <did it pass or fail?> | FR7, FR8 |
| TC3 | User has invalid username but valid password | Create invalid username and valid passwords | Empty string for username, valid string for password | Toast saying username must be at least one character | <actual output of test case> | <did it pass or fail?> | FR7, FR8 |
| TC4 | Valid username and password but passwords don't match | Create a valid username and two valid unidentical passowrds | String for username, string for entered password, different string for verified passowrd | Toast saying passwords must match | <actual output of test case> | <did it pass or fail?> | FR7, FR8, FR9 |
| TC5 | Testing if the game counter increments when the Play button is pressed | press the play button, check if database entry incremetns | valid user with number of games | game counter increments | <actual output of test case> | <did it pass or fail?> | FR12 |
| TC6 | Using search function to lookup a valid user | Enter a string into the search function containing a valid username | string which is also a valid username | TextView saying that the user is a valid user | <actual output of test case> | <did it pass or fail?> | FR15 |
| TC7 | Using the search function to lookup a user that doesn't exist | Enter a string into the search function containing a user that doesn't exist | string which is a non-existent user | TextView saying that the user is an invalid user | <actual output of test case> | <did it pass or fail?> | FR15 |
| TC8 | The logout button must dismiss the view | Press logout button, check if acitivity finishes | A logged in user | Activity will finish | Activity finished | pass | FR16 |
| TC9 | Having a valid username and password and not having errors | Enter a valid username and password from database, make sure user will get logged in | Valid username and password | User will be logged in | <actual output of test case> | <did it pass or fail?> | FR1, FR2 |
| TC10 | Check if first item is displayed upon playing the game | press the Play button, check if imageview contains valid text | Play button pressed | Will display a string of a restaurant | No string displayed | fail | FR21 |


## Integration tests
| ID | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------:| :----------: | :----------: | :----------: |
| TC1 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC2 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC3 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC4 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC5 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |

## System tests
| ID | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------:| :----------: | :----------: | :----------: |
| TC1 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC2 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC3 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC4 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC5 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |


# Software Artifacts
This section provides a list of the various artifacts and links we have created over the course of this semester to aid in the process of creating, developing, and testing our project.

* [Abby's Sign-up Use Case Diagram](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/artifacts/use_case_diagrams/SignupUseCase.pdf)
* [Clare's Login Use Case Diagram](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/artifacts/use_case_diagrams/use-case_diagram_log-in.pdf)
* [Kaitlyn's Search Function Use Case Diagram](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/artifacts/use_case_diagrams/Search%20Function%20Use%20Case%20Diagram.pdf)
* [High-Level Tasks](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/docs/High-Level-Tasks.md)
* [Gnatt Chart](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/docs/GanttChart.pdf)
* [Proposal](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/docs/proposal-template.md)
* [Midterm Software Requirement Specifications](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/docs/software_requirements_specification.md)