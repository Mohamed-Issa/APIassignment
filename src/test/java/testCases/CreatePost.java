package testCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import models.Posts;

public class CreatePost {

	@Test
	public void postFunction() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		Posts postModel = new Posts();
		postModel.setUserId(1);
		postModel.setBody("mohamed hamdy eissa create this is body");
		postModel.setTitle("mohamed hamdy eissa create this is title");

		given().header("Content-Type", "application/json").body(postModel).when().log().all().post("/posts").then()
				.log().all().assertThat().statusCode(201);
	}

}
