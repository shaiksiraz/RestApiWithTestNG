package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class TC002_PostRequest {
    @Test
    public void postRequest(){

        RestAssured.baseURI="http://restapi.demoqa.com/customer";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams= new JSONObject();
        requestParams.put("FirstName","Test67987");
        requestParams.put("LastName","check3221");
        requestParams.put("UserName","check5471");
        requestParams.put("Password","check7853");
        requestParams.put("Email","check49797@gmail.com");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST, "/register");
        System.out.println("response after posing the request is " + response.getBody().asString());
        int status = response.statusCode();
        Assert.assertEquals(201,status);
        System.out.println("Response code is  "+ status );
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals("OPERATION_SUCCESS",successCode);
        System.out.println("Success code is  "+ successCode);

    }
}
