package testCases;

import static io.restassured.RestAssured.given;

import java.util.List;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetUserPosts {

	@Test
	public void getUserPostsAndVerifyContainsValidsIDs() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		String response2 = given().header("Content-Type", "application/json").when().get("posts?userId=1")
				.then().extract().response().asString();

		// System.out.println(response2);
		JsonPath jsonPath = new JsonPath(response2);
		List<Integer> ids = jsonPath.getList("id");

		SoftAssert softAssert = new SoftAssert();

		for (int id : ids) {
			System.out.println(id);
			if (id >= 1 && id <= 100) {
				softAssert.assertTrue(true);
			} else {
				softAssert.assertTrue(false);
			}
		}
	}

}
