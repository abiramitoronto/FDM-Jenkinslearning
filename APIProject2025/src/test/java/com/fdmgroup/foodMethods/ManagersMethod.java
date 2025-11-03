package com.fdmgroup.foodMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Managers;
import com.fdmgroup.pojos.Staffs;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.http.ContentType;

public class ManagersMethod {
	
public static void PerformPUTManagers(String id) {
		  
		Staffs staffInfo1 = new Staffs(10, "Ami", 700);
		Staffs staffInfo2 = new Staffs(11, "Jack", 550);
		Staffs staffInfo3 = new Staffs(12, "Bruno", 800);
		
		List<Staffs> staffList = new ArrayList<>();
		staffList.add(staffInfo1);
		staffList.add(staffInfo2);
		staffList.add(staffInfo3);
		Managers managercontent = new Managers(1500,33,"Fish Fillet",staffList);
		  var response = given()
				  .contentType(ContentType.JSON)
				  .body(managercontent)
			 
			 .when()
			      .put("http://localhost:3000/managers/" + id)
			 .then()
			      .assertThat()
			         .statusCode(200);
		  
		  System.out.println(response.log().body());
			
	 }

public static void PerformDELETEStaffs(String managerName, int staffId) {
	  

//	@When("The user wants to delete information for staff with id {int} whose manager name is {string}")
//	public void the_user_wants_to_delete_information_for_staff_with_id_whose_manager_name_is(int staffId, String managerName) {
// 
	    
	    Managers[] managers = given()
	            .contentType(ContentType.JSON)
	            .log().all()
	        .when()
	            .get("http://localhost:3000/managers")
	        .then()
	            .log().all()
	            .statusCode(200)
	            .extract().as(Managers[].class);
 
	    
	    Managers targetManager = null;
	    for (Managers m : managers) {
	        if (m.getName().equalsIgnoreCase(managerName)) {
	            targetManager = m;
	            break;
	        }
	    }
	    
	    assertNotNull(targetManager, "Manager with name '" + managerName + "' not found");
 
	    
	    //targetManager.getStaffs().removeIf(s -> s.getId() == staffId);
	    
	    List<Staffs> staffList =  targetManager.getStaffs();
	    int staffCount = staffList.size();
	    staffList.remove(staffId);
	    
	    targetManager.setStaffs(staffList);
	    
	    
	    var response = given()
	            .contentType(ContentType.JSON)
	            .body(targetManager)
	            .log().all()
	            .pathParam("id", targetManager.getId())
	        .when()
	            .put("http://localhost:3000/managers/{id}")
	        .then()
	            .log().all()
	            .statusCode(200)
	            .extract().response();
	    
	    assertNotEquals(staffCount,targetManager.getStaffs().size());
	}


	
 
//	@Then("Count the number of managers has reduced by one")
//	public void count_the_number_of_managers_has_reduced_by_one() {
//	    
//	    Managers[] updatedManagers = given()
//	            .contentType(ContentType.JSON)
//	        .when()
//	            .get("http://localhost:3000/managers")
//	        .then()
//	            .statusCode(200)
//	            .extract().as(Managers[].class);
// 
//	    System.out.println("Total managers count after update: " + updatedManagers.length);
//	    assertThat("There should be at least one manager record", updatedManagers.length, greaterThan(0));
	
 
 
	
//	
//	  var response = given()
//			  
//			  .contentType(ContentType.JSON)
//			  .with()
//		  .pathParam("name", name)
//            .pathParam("id", id)
//			  
//		 
//		 .when()
//		      .delete("http://localhost:3000/managers/{name}/staffs/{id}")
//		 .then()
//		      .assertThat()
//		         .statusCode(200);
//	                .body("name", equalTo("Bell Pepper"))
//	                .body("remainingStaffCount", equalTo(2))
//	                .body("staffs.id", not(hasItem(staffId))) // Ensure deleted staff no longer present
//	                .extract().response();
//
//	        // Optional: print response for debugging
////	        System.out.println("Response JSON:");;
	  
	  
}




