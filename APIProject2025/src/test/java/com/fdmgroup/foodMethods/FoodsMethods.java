package com.fdmgroup.foodMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Foods;


import io.restassured.http.ContentType;

public class FoodsMethods {
	
	public static void performGETPost() {
		  var response = given()
				  .contentType(ContentType.JSON)
				  .log().all()
				  
			 .when()
			      .get("http://localhost:3000/foods")
			 .then()
			 .log().all()
			      .assertThat()
			         .body("id", containsInAnyOrder("1","2","3","4"))
		             .body("id",hasSize(4))
		             .body("name", containsInAnyOrder("cucumber salad","french fries","soft drink","burgers"))
		             .body("name",hasSize(4))
		             .header("Content-Type", is("application/json"))
		             .statusCode(200)
		             .extract().response();
		  
		// Deserialize JSON response to List of Post objects
			List<Foods> foods = response.jsonPath().getList("",Foods.class);
			
			
			//Assertion
			
			List<Double> prices = new ArrayList<>();
			for (Foods food : foods ) {
				prices.add(food.getPrice());
			}
			
			assertThat(prices, containsInAnyOrder(2.5,5.5,5.5,9.55));
			assertThat(prices,hasSize(4));
	 }
	
	public static void PerformPOSTPost(String id,String name,double price) {
		  
		  Foods foodcontent = new Foods(id, name, price);
		  
		  
		  var response = given()
				  .contentType(ContentType.JSON)
			 .with()
			      .body(foodcontent)
			 .when()
			      .post("http://localhost:3000/foods/")
			 .then()
			      .assertThat()
			         .statusCode(201);
		  
		  System.out.println(response.log().body());
		
	 }
	
	public static void PerformPUTPost(String id) {
		  
		
		Foods foodcontent = new Foods("momos",13.99);
		  var response = given()
				  .contentType(ContentType.JSON)
				  .body(foodcontent)
			 
			 .when()
			      .put("http://localhost:3000/foods/" + id)
			 .then()
			      .assertThat()
			         .statusCode(200);
		  
		  System.out.println(response.log().body());
			
	 }

}
