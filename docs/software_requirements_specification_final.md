# Overview

The purpose of this updated SRS is to layout the additional functional and non-functional requirments that we have added to complete our app. This document will describe functions that the app already contains and that are in the progress of being finished to ensure an optimal interaction with the app for users. Additionally, this document will explain our approach and use of various testing methods within the project. 

## Functional Requirements

### Login Menu
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR1 | Shall search for user's entered username from database to check if valid | TC9 |
| FR2 | Shall search for user's entered password from database to check if valid | TC9, TC1 |
| FR3 | The login button shall take the user to the home screen if user's information is valid | TC1, TC2, TC5 |
| FR4 | Users shall not be directed to the homescreen if the username and password provided are not valid | TC1 |
| FR5 | Shall require a username and password with each login | TC1 |


### Sign-up Menu
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR7 | Shall determine if the entered username meets all requirements | TC2, TC3, TC4 |
| FR8 | Shall determine if the entered password meets all requirements (at least 8 characters, 1 letter, 1 number, and 1 special character) | TC2, TC3, TC4 |
| FR9 | Shall determine if the re-entered password and original passwords match | TC4 |
| FR10 | The user's information should be entered into the database after signing up | TC5 |
| FR11 | The user shall not choose the same username as another registered user | TBD |


### Home Screen
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR12 | The counter shall track how many games users have played | TC5 |
| FR13 | The play button shall take users to the game screen | TC3, TC5 |
| FR14 | The profile button shall take users to their profile page | TC4, TC5 |
| FR15 | The search function shall look up users in the database by username | TC6, TC7 |
| FR16 | The logout button shall take users back to the login screen | TC8, TC5 |


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
| NFR1 | The app shall have a cohesive background, color, and style | TC2, TC3 |
| NFR2 | The text shall be easy to read for all users | TBD |
| NFR3 | The profile page shall contain only the users information | TBD |
| NFR4 | The home screen shall be the first page users see after logging in | TC2 |
| NFR5 | The homescreen shall contain data specific to each user | TBD |

### Storage
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR6 | The database shall be able to adapt to added data of users as time progresses | TC5 |
| NFR7 | There shall not be duplicate information for one specific user stored in the database | TBD |
| NFR8 | Database shall not delete users if capacity is reached | TBD |
| NFR9 | Database shall contain users name, username, and password | TC4 |
| NFR10 | The information stored in the database shall be able to be edited by users | TBD |

### Security
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR11 | The developers shall only be able to see all user details | TC4 |
| NFR12 | users shall not be able to collaborate with users they do not follow | TBD |
| NFR13 | Users shall only be able to edit their information stored by the database | TBD |
| NFR14 | Users shall not be able to see or access all stored data | TBD |
| NFR15 | Valid credentials shall be required with every login | TC1 |


# Test Specification
The purpose of this section is to list our unit tests, integration tests and system tests. Each category is then further broken down into a description, steps, input values, actual versus expected ouptut values, whether the test passed or failed, and a requirements ID that links together the requirement with its test case. 

## Unit tests
| ID | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------:| :----------: | :----------: | :----------: |
| TC1 | Require a username and password with each login | Attempt to login without credentials | empty strings in username and password | Toast saying invalid username/password | Toast saying the user has invalid username | pass | FR4, FR5, NFR15 |
| TC2 | User has valid username but invalid password | create a valid username and an invalid password | valid string for username, invalid string for password | Toast saying Password must contain 1 uppercase, 1 letter, 1 number and 1 special character | Toast saying Password must contain 1 uppercase, 1 letter, 1 number and 1 special character | pass | FR7, FR8 |
| TC3 | User has invalid username but valid password | Create invalid username and valid passwords | Empty string for username, valid string for password | Toast saying username must be at least one character | Message appears saying username must be at least one character | pass | FR7, FR8 |
| TC4 | Valid username and password but passwords don't match | Create a valid username and two valid unidentical passowrds | String for username, string for entered password, different string for verified passowrd | Toast saying passwords must match | Message saying passwords must match | pass | FR7, FR8, FR9 |
| TC5 | Testing if the game counter increments when the Play button is pressed | press the play button, check if database entry incremetns | valid user with number of games | game counter increments | Game counter on main screen increments | pass | FR12, NFR6 |
| TC6 | Using search function to lookup a valid user | Enter a string into the search function containing a valid username | string which is also a valid username | TextView saying that the user is a valid user | TextView says that the entered user is a valid user | pass | FR15 |
| TC7 | Using the search function to lookup a user that doesn't exist | Enter a string into the search function containing a user that doesn't exist | string which is a non-existent user | TextView saying that the user is an invalid user | TextView says that the user is an invalid user | pass | FR15 |
| TC8 | The logout button must dismiss the view | Press logout button, check if acitivity finishes | A logged in user | Activity will finish | Activity finished | pass | FR16 |
| TC9 | Having a valid username and password and not having errors | Enter a valid username and password from database, make sure user will get logged in | Valid username and password | User will be logged in | User gets logged in with Firebase | pass | FR1, FR2 |
| TC10 | Check if first item is displayed upon playing the game | press the Play button, check if imageview contains valid text | Play button pressed | Will display a string of a restaurant | No string displayed | fail | FR21 |


## Integration tests
| ID | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------:| :----------: | :----------: | :----------: |
| TC1 | Login page should only take user to homescreen if provided credentials are vaild | Attempt to login with invalid credentials | Credentials not stored in database | Message will be displayed that the credentials are invalid | Message was displayed that credentials were invalid and user was not taken to the homescreen | Pass | FR3 |
| TC2 | Login page should take user to home page | Attempt to login with valid credentials | Credentials stored in the database | User will be taken to their homescreen | User was taken to the homescreen | Pass | FR5, NFR4 |
| TC3 | Play button when pressed should initiate a new game | Pressing the play button should transition to the game screen | User selects the play button | Game play screen will be displayed | Game play screen was displayed | Pass | FR13 |
| TC4 | Profile button when pressed should transition to the users profile page | Pressing the profile button should transition to the users profile page | User selects the profile button | Only users profile page will be displayed | Only that users profile page was displayed after pressing the profile button | Pass | FR14 |
| TC5 | When the user signs up for the first time their information is entered into the database| User provides a valid username, password, and reconfirms password | Username and password provided | That username will be entered into the database and users should be able to search that user | Usernames and password were stored in the database and users were able to search other users by there username. No personal information was displayed to other users. | Pass | FR10 |

## System tests
| ID | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------:| :----------: | :----------: | :----------: |
| TC1 | System should only allow login with correct password for username | Try to login to known users account with wrong password | Valid username and invalid password | System should deny access to account | System denies access to account and displays an error message | Pass | FR2 |
| TC2 | The application should work with all Android emulators | Install the application on several mobile Android emulators | Install app on Pixel 4, Pixel 2, Nexus 4, 8" Foldable | App should function on all emulators | App functioned on multiple emulators | Pass | NFR1 |
| TC3 | Application should perform fast and smoothly | Inspect CPU activity with CPU Profiler | Run CPU Profiler while app runs | Green, yellow, or gray coloring to signify CPU performance | App ran smoothly and CPU usage was satisfactory | Pass | NFR1 |
| TC4 | System should store users username, password, and games played | Check that database is saving user data | Create account on app | Database should have information stored | Database contains data that was to be stored | Pass | NFR9, NFR11 |
| TC5 | Application should have proper usability in all buttons | Check that all buttons are usable | All buttons in the app | Buttons should do the tasks they are assigned | All buttons except the game buttons function properly | Passed usability test on all buttons except game buttons | FR3, FR13, FR14, FR16 |


# Software Artifacts

This section provides a list of the various artifacts and links we have created over the course of this semester to aid in the process of creating, developing, and testing our project.

* [Abby's Sign-up Use Case Diagram](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/artifacts/use_case_diagrams/SignupUseCase.pdf)
* [Clare's Login Use Case Diagram](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/artifacts/use_case_diagrams/use-case_diagram_log-in.pdf)
* [Kaitlyn's Search Function Use Case Diagram](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/artifacts/use_case_diagrams/Search%20Function%20Use%20Case%20Diagram.pdf)
* [High-Level Tasks](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/docs/High-Level-Tasks.md)
* [Gnatt Chart](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/docs/GanttChart.pdf)
* [Proposal](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/docs/proposal-template.md)
* [Midterm Software Requirement Specifications](https://github.com/abbybowerman/GVSU-CIS350-Brewing-Java/blob/master/docs/software_requirements_specification.md)
