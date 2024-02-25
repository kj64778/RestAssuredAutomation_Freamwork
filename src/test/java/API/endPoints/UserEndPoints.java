package API.endPoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import API.payLoad.Users;
import io.restassured.http.ContentType;

public class UserEndPoints {
	
	public static Response createUser(Users payload) {

		Response response = 	given()
										.accept(ContentType.JSON)
										.contentType(ContentType.JSON)
										.body(payload)
								.when()
										.post(RoutesURL.postURL);

		return response;

	}
	
	//Get Requtes 
	
	public static Response getUser(String userName) {
		
		

		Response response = 	given()
										.accept(ContentType.JSON)
										.pathParam("username", userName)
										
								.when()
										.get(RoutesURL.getURL);

		return response;

	}
	
	//Update user
	
	public static Response putUser(String userName, Users payload) {

		Response response = 	given()
										.accept(ContentType.JSON)
										.contentType(ContentType.JSON)
										.pathParam("username", userName)
										.body(payload)
								.when()
										.put(RoutesURL.putURL);

		return response;

	}
	
	
	//Delete request
	public static Response deleteUser(String userName) {

		Response response = 	given()
										.accept(ContentType.JSON)
										.pathParam("username", userName)
								.when()
										.delete(RoutesURL.deleteURL);

		return response;

	}
	
	

}
