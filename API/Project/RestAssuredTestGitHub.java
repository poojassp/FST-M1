import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTestGitHub {
  
  RequestSpecification requestSpec;
  String SSHkey;
  int ID;
  
  @BeforeClass
	public void setUp() {
	    // Create request specification
	    requestSpec = new RequestSpecBuilder()
	        .setContentType(ContentType.JSON)
	        .setBaseUri("https://api.github.com").log(LogDetail.ALL)
	        .addHeader("Authorization", "Token")
	        .build();
	}
  
  @Test(priority=1)
  public void postRequest() {
      // Create JSON request
      String reqBody = "{\"title\":\"testAPIKey\", \"key\" :\"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDfOMghazCTGNGZbXhb3xJS8Ua6aht0FvqSgRbir\"}";

     
    Response response = 
  	        given().spec(requestSpec) // Use requestSpec
  	      .body(reqBody) // Add request body
          .when().post("/user/keys"); // Send POST request
    
 // Print response of POST request
    String body = response.getBody().asPrettyString();
    System.out.println(body);
    
    
    ID =response.then().extract().path("id");
  System.out.println("id is "+ID);
    //response.then().body("id", equalTo("ID"));
    // Assertion
   
   response.then().statusCode(201);
  }
  
  //get request
  @Test(priority=2)
  public void getRequest() {
	  
	   
	    Response response= 
	  	        given().spec(requestSpec) // Use requestSpec
	  	      .when().get("/user/keys"); // Send get request
	    
	    //print response of get request
	    
	    String body = response.getBody().asPrettyString();
	    System.out.println("Body of the get request is" +body);
	    
	    response.then().statusCode(200);
	  
  }
  

//delete request
  @Test(priority=3)
  public void deleteRequest() {
	  
	  Response response= 
	  	        given().spec(requestSpec) // Use requestSpec
	  	      .when().pathParam("keyid", ID).delete("/user/keys/{keyid}"); // Send delete request
	  
	  Reporter.log("response is " +response);
	  response.then().statusCode(204);
	  
  }
  
  
  
}