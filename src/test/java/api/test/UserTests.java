package api.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import api.endpoints.UserEndpoints;
import api.utilities.Excelutil;
import io.restassured.response.Response;

public class UserTests 
{		
    static int userid;
    static int userid1;
    static String user_first_name;
    static String user_first_name1;
    
	@Test(priority=1)
	public void testPostUser() 
    {	
        JSONObject userData = Excelutil.excelreader(1);
        Response response = UserEndpoints.createUser(userData);
        response.then().log().all();
        Assert.assertEquals(201, response.getStatusCode()); 
        userid = response.path("user_id");
        user_first_name = response.path("user_first_name");
	}
	   
	@Test(priority=2)
	public void testGetUser()
	{
		Response response=UserEndpoints.retriveAllUsers();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}	

	@Test(priority=3)
	public void testGetUserByName()
	{
		Response response=UserEndpoints.retriveUserbyName(user_first_name);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}	
	
	@Test(priority=4)
	public void testGetUserById()
	{
		Response response=UserEndpoints.retriveUserbyId(userid);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}	
	
	@Test(priority=5)
	public void testPutUserById() 
	{	
		Response response = UserEndpoints.updateUser(Excelutil.excelreader(2),userid);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		user_first_name1 = response.path("user_first_name");		    
	} 
	
	@Test(priority=6)
	public void testDeleteUserByName()
	{
		Response response=UserEndpoints.deleteUserbyName(user_first_name1);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	} 	
	
	@Test(priority=7)
	public void testPostUseragain() 
	{  
		 JSONObject userData = Excelutil.excelreader(1);
	     Response response = UserEndpoints.createUser(userData);
	     response.then().log().all();
	     Assert.assertEquals(201, response.getStatusCode()); 
	     userid1= response.path("user_id");
	} 
		
	@Test(priority=8)
	public void testDeleteUserById()
	{	
		Response response=UserEndpoints.deleteUserbyId(userid1);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);	
	}		
}

