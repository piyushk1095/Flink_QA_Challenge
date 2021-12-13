$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("resources/feature/WeatherShopper.feature");
formatter.feature({
  "name": "Automation test for Flink QA Challenge ( Weather Shopper)",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Online shopping based on current temperature on Chrome Browser",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to Home page",
  "keyword": "Given "
});
formatter.match({
  "location": "WeatherShopper.userNavigatesToHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User checks current temperature",
  "keyword": "When "
});
formatter.match({
  "location": "WeatherShopper.userChecksCurrentTemperature()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks for correct cream based on the temperature",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherShopper.userClicksForCorrectCreamBasedOnTheTemperature()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User updates the cart with correct products and makes payment",
  "keyword": "Then "
});
formatter.match({
  "location": "WeatherShopper.userUpdatesTheCartWithCorrectProducts()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Online shopping based on current temperature on Firefox Browser",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to Home page",
  "keyword": "Given "
});
formatter.match({
  "location": "WeatherShopper.userNavigatesToHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User checks current temperature",
  "keyword": "When "
});
formatter.match({
  "location": "WeatherShopper.userChecksCurrentTemperature()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks for correct cream based on the temperature",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherShopper.userClicksForCorrectCreamBasedOnTheTemperature()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User updates the cart with correct products and makes payment",
  "keyword": "Then "
});
formatter.match({
  "location": "WeatherShopper.userUpdatesTheCartWithCorrectProducts()"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[Your payment was successful. You should receive a follow-up call from our sales team].\u003e but was:\u003c[Oh, oh! Your payment did not go through. Please bang your head against a wall, curse the software gods and then try again].\u003e\n\tat org.junit.Assert.assertEquals(Assert.java:115)\n\tat org.junit.Assert.assertEquals(Assert.java:144)\n\tat com.glue.WeatherShopper.userUpdatesTheCartWithCorrectProducts(WeatherShopper.java:76)\n\tat ✽.User updates the cart with correct products and makes payment(resources/feature/WeatherShopper.feature:13)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});