package com.fdmgroup.Stepdef;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Comments;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class F2_CommentsTest_Stepdefinition {
	
	private Response response;
	
	

@When("User sends a POSTcreate request for {string},{int},{string},{int} with the following details")
public void user_sends_a_pos_tcreate_request_for_with_the_following_details(String id, int userid, String body, int foodId) {

	  Comments postcontent = new Comments(id,userid,body,foodId);
	  
	  
	 response = given()
			  .contentType(ContentType.JSON)
			  .log().all()
		 .with()
		      .body(postcontent)
		 .when()
		      .post("http://localhost:3000/comments")
		 .then()
		 .log().all()
		      .assertThat()
		         .statusCode(201)
		         .extract().response();
//	  System.out.print("info" +id, userid, body, foodId);
	  
}

@Then("User receives a valid create response with status code {int}")
public void user_receives_a_valid_create_response_with_status_code(int status) {
	assertThat(response.getStatusCode(), is(status));
}

@When("User sends a DELETE request to delete using {string}")
public void user_sends_a_delete_request_to_delete_using(String id) {
	response = given()
			  .contentType(ContentType.JSON)
			  .log().all()
		.with()
		      .pathParam("commentId",id)
		 .when()
		      .delete("http://localhost:3000/comments/{commentId}")
		 .then()
		 .log().all()
		      .assertThat()
		         .statusCode(200)
		         .extract().response();
}

@Then("User receives a valid  delete response with status code {int}")
public void user_receives_a_valid_delete_response_with_status_code(int status) {
	assertThat(response.getStatusCode(), is(status));
}


@When("the User sends {int}, {int}, {string} to view the body")
public void the_user_sends_to_view_the_body(int userid, int foodId, String body) {
	response = given()

			  .contentType(ContentType.JSON)
			  .log().all()
		 .with()
		      .queryParam("foodId",foodId)
		      .queryParam("userid", userid)
		 .when()
		      .get("http://localhost:3000/comments/")
		 .then()
		 .log().all()
		      .assertThat()
		         .body("body", hasItem(body))
		         .extract().response();
	  
	Comments[] comments = response.as(Comments[].class);
	 assertThat(comments.length, is(1));
	 
	 
		List<String> bodies = new ArrayList<>();
		for (Comments comment : comments ) {
			bodies.add(comment.getBody());
		}
		assertThat(bodies,hasItem(body));
}

@Then("User receives a valid updated response with status code {int}")
public void user_receives_a_valid_updated_response_with_status_code(int status) {
	assertThat(response.getStatusCode(), is(status));
}

	
}
