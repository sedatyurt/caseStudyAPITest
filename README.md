# caseStudyAPITest

### Requirements

- JDK 17
- Maven


### How to Run

- `mvn clean install -DskipTests=true`
- `mvn clean verify -am -Dsurefire.suiteXmlFiles=src/test/resources/test-suite.xml -Dapi=java -Dtestng.dtd.http=true`
- `mvn allure:report -Dallure.results.directory=src/target/allure-results/`

or 

- `docker build .`

### Test Reports
You can find the test reports at **target/site/allure-maven-plugin/index.html**
You can find the API responses at **responses** directory 



### Used Technologies

- Rest-Assured
- TestNG
- Allure Reports
- Docker
