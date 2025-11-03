package com.fdmgroup.Stepdef;


import static org.hamcrest.Matchers.containsInAnyOrder;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import com.fdmgroup.pojos.Foods;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class F1_FoodTest_Stepdefinition {
	
	private Response response;
	
	@Given("the base URL is {string}")	
    public void the_base_url_is(String URL) {
		baseURI = URL;
    }
	@When("User send the request to the URL {string}")
	public void user_send_the_request_to_the_url(String URL) {
	   
	
	
		System.out.println("Message" + baseURI + URL);
		
		 response = given()
				  .contentType(ContentType.JSON)
				  .log().all()
				  
			 .when()
			      .get(baseURI + URL)
			 .then()
			 .log().all()
			      .assertThat()
		             .body("name", containsInAnyOrder("cucumber salad","french fries","soft drink","burgers"))
		             .body("name",hasSize(4))
		             .header("Content-Type", is("application/json"))
		             .statusCode(200)
		             .extract().response();
		
	}

	@Then("User receives a valid response with status code {int}")
	public void user_receives_a_valid_response_with_status_code(Integer status) {
		assertThat(response.getStatusCode(), is(status));
	}
	
	@Then("the response contains a list of foods with all the information")
	public void the_response_contains_a_list_of_foods_with_all_the_information() {
		// Deserialize JSON response to List of Post objects
					List<Foods> foods = response.jsonPath().getList("",Foods.class);
					
					
					//Assertion
					List<String> ids = new ArrayList<>();
					for (Foods food : foods ) {
						ids.add(food.getId());
					}
					assertThat(ids, containsInAnyOrder("1","2","3","4"));
					assertThat(ids,hasSize(4));
					
					List<Double> prices = new ArrayList<>();
					for (Foods food : foods ) {
						prices.add(food.getPrice());
					}
					
					assertThat(prices, containsInAnyOrder(2.5,5.5,5.5,9.55));
					assertThat(prices,hasSize(4));
	}

	@When("User sends a POST request for {string},{string},{double} following item")
	public void user_sends_a_post_request_for_following_item(String id, String name, Double price) {
		Foods foodcontent = new Foods(id, name, price);
		  
		  
		  response = given()
				  .contentType(ContentType.JSON)
			 .with()
			      .body(foodcontent)
			 .when()
			      .post("http://localhost:3000/foods/")
			 .then()
			      .assertThat()
			         .statusCode(201)
			         .extract().response();
		  
		  System.out.println("Resrponse" + response);
	}

	@Then("User will get a valid response with status code {int}")
	public void user_will_get_a_valid_response_with_status_code(Integer status) {
		assertThat(response.getStatusCode(), is(status));
	}

	@Then("the new food item will be visible in the db")
	public void the_new_food_item_will_be_visible_in_the_db() {
		assertThat(response.jsonPath().getString("id"), is("5"));
		assertThat(response.jsonPath().getString("name"), is("Momos"));
		assertThat(response.jsonPath().getDouble("price"), is(6.99));
	}

	

	@Given("User update the price of the food item using {string} and {double}")
	public void user_update_the_price_of_the_food_item_using_and(String id, Double price) {
	    
		Foods foodcontent = new Foods(id,price);
		   response = given()
				  .contentType(ContentType.JSON)
				  .body(foodcontent)
			 
			 .when()
			      .patch("http://localhost:3000/foods/" + id)
			 .then()
			      .assertThat()
			         .statusCode(200)
			         .extract().response();
		  
		  
	}

	@Then("the food item price should be updated")
	public void the_food_item_price_should_be_updated() {
		assertThat(response.jsonPath().getDouble("price"), is(8.99));
		assertThat(response.getStatusCode(), is(200));
	}


}
