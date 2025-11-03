package com.fdmgroup.foodMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Comments;


import io.restassured.http.ContentType;

public class CommentsMethods {
	public static void PerformPOSTComments(String id,int userid,String body,int foodId) {
		  
		  Comments postcontent = new Comments(id, userid, body, foodId);
		  
		  
		  var response = given()
				  .contentType(ContentType.JSON)
			 .with()
			      .body(postcontent)
			 .when()
			      .post("http://localhost:3000/comments/")
			 .then()
			      .assertThat()
			         .statusCode(201);
		  
		  System.out.println(response.log().body());
		
	 }
	
	public static void PerformDELETEComments(int id) {
		  
		
		  var response = given()
				  .contentType(ContentType.JSON)
				  
			 
			 .when()
			      .delete("http://localhost:3000/comments/" + id)
			 .then()
			      .assertThat()
			         .statusCode(200);
		  
		  
	 }
	
	public static void PerformGETCommentsQueryParameter(int foodId,int userid,String body) {
		  Comments[] comments = given()
				  .contentType(ContentType.JSON)
			 .with()
			      .queryParam("foodId",foodId)
			      .queryParam("userid", userid)
			 .when()
			      .get("http://localhost:3000/comments/")
			 .then()
			      .assertThat()
			         .body("body", hasItem(body))
			         .extract().as(Comments[].class);
		  
		 assertThat(comments.length, is(1));
		 
		 
			List<String> bodies = new ArrayList<>();
			for (Comments comment : comments ) {
				bodies.add(comment.getBody());
			}
			assertThat(bodies,hasItem(body));
			
	 }

}
