package API.endPoints;

public class RoutesURL {
	
	//URL Class
	
	/*
	 * Base URL- https://petstore.swagger.io/v2
	 * POST	https://petstore.swagger.io/v2/user
		GET	https://petstore.swagger.io/v2/user/{Username}
		PUT	https://petstore.swagger.io/v2/user/{Username}
		Delete	https://petstore.swagger.io/v2/user/{Username}

	 */
	
	//Usere Model URL
	
	public static String baseURL ="https://petstore.swagger.io/v2";
	
	//request URL for user Model
	public static String postURL = baseURL+"/user";
	public static String getURL = baseURL+"/user/{username}";
	public static String putURL = baseURL+"/user/{username}";
	public static String deleteURL = baseURL+"/user/{username}";
	
	
	//--------------------------------------------------------------------
	
	//Pet Model URL
	
	
	
	
	
	
	//---------------------------------------------------------------
	//Store Model URL
	

}
