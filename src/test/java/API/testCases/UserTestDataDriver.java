package API.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import API.endPoints.UserEndPoints;
import API.payLoad.Users;
import API.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDataDriver {
	
	
	
	@Test(priority = 1, dataProvider ="AllData", dataProviderClass = DataProviders.class )
	public  void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pass, String phone) {
		
		Users userpayload = new Users();
		
//		userpayload.setId(Integer.parseInt(userId));
//		userpayload.setId(Integer.parseInt(userId));
		userpayload.setUsername(UserName);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(email);
		userpayload.setPassword(pass);
		userpayload.setPhone(phone);
	
		
		
		
		Response response = UserEndPoints.createUser(userpayload);
	
		System.out.println("-----Create User Body------------");
		response.then()
		.log()
		.all();
		response.then().statusCode(200);
	}
	
	
	
	@Test(priority = 2, dataProvider ="UserNameData", dataProviderClass = DataProviders.class )
	public  void testdeleteUser(String username) {
		
		Response response = UserEndPoints.deleteUser(username);
	
		System.out.println("-----Create User Body------------");
		response.then()
		.log()
		.all();
//		response.then().statusCode(200);
	}
	




}
