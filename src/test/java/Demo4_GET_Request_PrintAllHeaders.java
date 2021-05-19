import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo4_GET_Request_PrintAllHeaders {
    @Test
    public void GetWeatherDetails(){


        //Specify the base URI
        RestAssured.baseURI="https://restapi.demoqa.com/utilities/weather/city";

        //Request Object
        RequestSpecification httpRequest=RestAssured.given();

        Response response=httpRequest.request(Method.GET,"/Delhi");

        String responseBody=response.getBody().asString();
        System.out.println("ResponseBody is:" +responseBody);

        Assert.assertEquals(responseBody.contains("Delhi"),true);

    }
}
