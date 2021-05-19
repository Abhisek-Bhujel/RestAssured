import groovyjarjarantlr4.v4.runtime.BaseErrorListener;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc002_POST_Request {

    @Test
    void RegistrationSuccessful(){

        //Specify base URI

        RestAssured.baseURI="http://restapi.demoqa.com/customer";

        //Request object created
        RequestSpecification httpRequest= RestAssured.given();

        //Response payload sending along with post request
        JSONObject requestParams=new JSONObject();
        requestParams.put("FirstName","JohnXYZ");
        requestParams.put("LastName","XYZJohn");
        requestParams.put("UserName","JohnXYZ");
        requestParams.put("Password","JohnXYZxyz");
        requestParams.put("Email","JohnXYZ@gmail.com");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString());

        Response response=httpRequest.request(Method.POST,"/register");




        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        //status code validation
        int statusCode=response.statusCode();
        System.out.println("statusCode is "+statusCode);
        Assert.assertEquals(statusCode,201);

        //status line verification
        String statusLine=response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 201 OK");

        String successCode=response.jsonPath().get("SuccessCode");
        Assert.assertEquals("successCode","OPERATION_SUCCESS");

    }


}
