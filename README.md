## RUN TESTS

 To generate test runners execute mvnw -P generate generate-test-sources
 To run generated runners execute mvnw -P run integration-test

## REPORTING:

 In order to generate Cluecumber report use such command after test run:
 mvnw -P generate-report post-integration-test

 Report will be saved in the {projectDirectory}/target/generated-report.index.html

 NOTE: During run with Junit if test fails not on the assertions,screenshot will be saved in the such directory():
 {projectDirectory}/build/reports/tests     (file name of the screenshot is Logged during the run in console)
