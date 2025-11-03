package com.fdmgroup.Stepdef;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Managers;
import com.fdmgroup.pojos.Staffs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class F3_ManagersTest_Stepdefinition {
	private Response response;
	static int staffCount;
	@When("User updates the staff information using Manager {string}")
	public void user_updates_the_staff_information_using_manager(String id) {
		Staffs staffInfo1 = new Staffs(10, "Ami", 700);
		Staffs staffInfo2 = new Staffs(11, "Jack", 550);
		Staffs staffInfo3 = new Staffs(12, "Bruno", 800);
		
		List<Staffs> staffList = new ArrayList<>();
		staffList.add(staffInfo1);
		staffList.add(staffInfo2);
		staffList.add(staffInfo3);
		Managers managercontent = new Managers(1000,35,"Bell Pepper",staffList);
		   response = given()
				  .contentType(ContentType.JSON)
				  .body(managercontent)
			 
			 .when()
			      .patch("http://localhost:3000/managers/" + id)
			 .then()
			      .assertThat()
			         .statusCode(200)
		   .extract().response();
		 
	}

	@Then("User should see the updated staff informartion")
	public void user_should_see_the_updated_staff_informartion() {
		assertThat(response.getStatusCode(), is(200));
	}
	
	@When("User deletes the staff whose id is {int} under manager name {string}")
	public void user_deletes_the_staff_whose_id_is_under_manager_name(int staffId, String managerName) {
		 
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
 
	    
	   
	    
	    List<Staffs> staffList =  targetManager.getStaffs();
	    staffCount = staffList.size();
	    staffList.remove(staffId);
	    
	    targetManager.setStaffs(staffList);
	    
	    
	    response = given()
	            .contentType(ContentType.JSON)
	            .body(targetManager)
	            .log().all()
	            .pathParam("id", targetManager.getId())
	        .when()
	            .put("http://localhost:3000/managers/{id}")
	        .then()
	            .log().all()
	            .assertThat()
	             .statusCode(200)
	             .extract().response();
	    
	    
	}

	@Then("User should verify the updated list of staff count under that manager name {string}")
	public void user_should_verify_the_updated_list_of_staff_count_under_that_manager_name(String managerName){
		
		Managers[] managers = given()
	            .contentType(ContentType.JSON)
	            .log().all()
	        .when()
	            .get("http://localhost:3000/managers")
	        .then()
	            .log().all()
	            .assertThat()
	            .statusCode(200)
	            .extract().as(Managers[].class);
 
	    
	    Managers targetManager = null;
	    for (Managers m : managers) {
	        if (m.getName().equalsIgnoreCase(managerName)) {
	            targetManager = m;
	            break;
	        }
	    }
	    assertNotEquals(staffCount,targetManager.getStaffs().size());
	    
	   
	}


}
