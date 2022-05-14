FROM maven:3.8.3-openjdk-17
COPY . /caseStudyAPITest
WORKDIR /caseStudyAPITest
RUN mvn clean install -DskipTests=true
RUN mvn clean verify -am -Dsurefire.suiteXmlFiles=src/test/resources/test-suite.xml -Dapi=java -Dtestng.dtd.http=true
RUN mvn allure:report -Dallure.results.directory=src/target/allure-results/
