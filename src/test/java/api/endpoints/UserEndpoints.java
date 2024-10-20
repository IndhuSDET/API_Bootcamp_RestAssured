package api.endpoints;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserEndpoints {
		 
	public static Response createUser(JSONObject userBody)
	{		
		Response response=	RestAssured.
		given()
		  .auth().basic("Numpy@gmail.com","userapi@october")
		  .header("Cookie", "JSESSIONID=76EEE3A1FF11E0748161228BB113E4D6")
          .header("Cache-Control", "no-cache")
          .header("Content-Type", "application/json")
 		  .body(userBody.toString())		
		.when()
		  .post(Routes.postURL);
		return response;
	}
	
	public static Response retriveAllUsers()
	{
		Response response=	RestAssured.
		given()
		   .auth().basic("Numpy@gmail.com","userapi@october")
		.when()
		   .get(Routes.getallURL);	 
		return response;
	}
	
	public static Response retriveUserbyId(int userid)
	{
		Response response=	RestAssured.
		given()
		    .auth().basic("Numpy@gmail.com","userapi@october")
		    .pathParam("userId",userid)    
		.when()
		   .get(Routes.getbyidURL);
		return response;	   	
	}	
	
	public static Response retriveUserbyName(String user_first_name)
	{
		Response response=	RestAssured.
		given()
		   .auth().basic("Numpy@gmail.com","userapi@october")
		   .pathParam("userFirstName",user_first_name) 
		.when()
		   .get(Routes.getbynameURL);
		return response;	   	
	}
	
	public static Response updateUser(JSONObject userBody,Integer userid)
	{
		Response response=	RestAssured.
		given()
		  .auth().basic("Numpy@gmail.com","userapi@october")
		  .pathParam("userId",userid)
		  .header("Cookie", "JSESSIONID=76EEE3A1FF11E0748161228BB113E4D6")
          .header("Cache-Control", "no-cache")
          .header("Content-Type", "application/json")
		  .body(userBody.toString())	    
		.when()
		   .put(Routes.updatebyidURL);
		 return response;		   	
	}	
	
	public static Response deleteUserbyName(String user_first_name)
	{
		Response response= RestAssured.
		given()
		   .auth().basic("Numpy@gmail.com","userapi@october")
		   .pathParam("userFirstName",user_first_name)
		.when()
		   .delete(Routes.deletebynameURL);
		 return response;		   	
	}	
	
	public static Response deleteUserbyId(Integer userid)
	{
		Response response=	RestAssured.
		given()
		   .auth().basic("Numpy@gmail.com","userapi@october")
		   .pathParam("userId",userid)
		.when()
		   .delete(Routes.deletebyidURL);
		 return response;		   	
	}	
	
}