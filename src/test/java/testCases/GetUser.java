package testCases;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class GetUser {

	@Test
	public void getRondomUserAndPrintHisEmail() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

		String response = given().header("Content-Type", "application/json").when().get("users/1").then().extract()
				.response().asString();

		// System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		String email = jsonPath.getString("email");

		if (!email.isEmpty()) {
			System.out.println(email);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}


}
