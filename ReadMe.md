Introduction:
===============

Android application automation using Page Object Model framework using Appium and webdriver 
 
Prerequisites:
===============

* Java JDK 
* Eclipse with Maven plugin installed 
* Android SDK
* Appium 1.6.5

Setup:
============

1. Clone the project from git
2. Launch Eclipse
3. click on File -> Import
5. Select Maven -> Existing Maven Projects and click on Next button
5. Click on Browse and navigate to git directory and select folder
6. Select pom.xml and click on finish button.

Framework Description:
============

Our automation tests are designed in Page Object Model over the top of cucumber jvm framework.

src/test/resources:
------------------- 

Resources folder contains cucumber feature files, configuration files and browser drivers
 
* create your BDD scenarios in features folder and are organize them with tags eg. "@regression", "@smoke", "@wip"
 
src/main/java:
-----------------

This folder contains 2 packages pagemodel and utils. 
 * Pagemodel package, we create java classes for each screen consists of reusable functions performing specific test logic like login, etc.,
 * utils package contains Support class with reusable functions.
 

src/test/java:
--------------	
This folder contains packages acceptanceTest and stepdefs

* acceptanceTest package contains driver classes for running specific test suites.

* step definitions for all features added in features folder are added in stepdefs package.

Executing Tests:
================ 

To run tests, Add you apk file to project root directory and update file name in SharedWebDriver.java file. Start Appium server.
 

1. select RegressionTest.java from acceptanceTest package under folder src/test/java
2. Click on Run menu option and select run as JUnit Tests





 