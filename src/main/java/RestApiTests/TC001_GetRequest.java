package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.testng.annotations.Test;


public class TC001_GetRequest {
    @Test
    public void getWeatherDetails(){
        //Specify URI
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET, "/Hyderabad");
        System.out.println("Response of Hyderabad reqest is "+ response.body().asString()   );

        Assert.assertEquals(200,response.getStatusCode());

        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());

        //Assert.fail("Intentionally failed");

    }
}
