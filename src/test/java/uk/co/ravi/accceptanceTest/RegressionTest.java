package uk.co.ravi.accceptanceTest;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty","html:target/reports/reg-test-report","json:target/reports/reg-test-report/report.json"}, 
		features = {"src/test/resources/features/"},glue="uk.co.ravi.stepdefs")
public class RegressionTest {

}
