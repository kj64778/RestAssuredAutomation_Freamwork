package API.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import API.endPoints.UserEndPoints;
import API.payLoad.Users;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	Users userpayload;
	
	@BeforeClass
	public void generteTestData() {
		faker = new Faker();
		userpayload =new Users();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	//perform Post request
	
	@Test(priority = 1)
	public  void testCreateUser() {
		Response response = UserEndPoints.createUser(userpayload);
	
		System.out.println("-----Create User Body------------");
		response.then()
		.log()
		.all();
		response.then().statusCode(200);
	}
	
	//perform Get request
	

	
	@Test(priority = 2)
	public void testGetUser() {
		Response response = UserEndPoints.getUser(this.userpayload.getUsername());
		
		//Log BOdy
		System.out.println("------------------Get User Body--------------------");
		response.then().log().all();
		
		//validate Status code
		response.then().statusCode(200);
		
	}
	
	//Perfor Update User
	
	@Test(priority = 3)
	public void testUpdateUser() {
		userpayload.setFirstName(faker.name().firstName());
		Response response = UserEndPoints.putUser(this.userpayload.getUsername(), userpayload);
		
		//Log Body
		System.out.println("-----Update User Body------------------");
		response.then().log().all();
		//vallidate statuc code
		response.then().statusCode(200);
	}
	
	//Perform Delete user
	
	@Test(priority = 4)
	public void testdeleteUser() {
		Response response = UserEndPoints.deleteUser(this.userpayload.getUsername());
		
		//Body Log
		System.out.println("------Delete User Body Log---------");
		response.then().log().all();
		
		//validate Statuc code
		
		response.then().statusCode(200);
	}
	
	

}
