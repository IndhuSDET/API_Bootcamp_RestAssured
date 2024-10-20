package api.endpoints;

public class Routes
{

	public static String baseURL="https://userserviceapp-f5a54828541b.herokuapp.com/uap";
	public static String postURL=baseURL+"/createusers";
	public static String getallURL=baseURL+"/users";
	public static String getbyidURL=baseURL+"/user/{userId}";
	public static String updatebyidURL=baseURL+"/updateuser/{userId}";
	public static String getbynameURL=baseURL+"/users/username/{userFirstName}";
	public static String deletebynameURL=baseURL+"/deleteuser/username/{userFirstName}";
	public static String deletebyidURL=baseURL+"/deleteuser/{userId}";	
	public static String exceldatapath="/src/test/resources/user_contract2..xlsx";

}









