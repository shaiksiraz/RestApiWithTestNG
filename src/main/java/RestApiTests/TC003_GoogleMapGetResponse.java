package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_GoogleMapGetResponse {
    @Test
    public void verifyResponseOfGoogleMap(){

        RestAssured.baseURI="https://maps.googleapis.com";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
        String body = response.getBody().asString();
        System.out.println("Response body was " + body);

        String hdrContentType = response.header("Content-Type");
        System.out.println("Header value is "+ hdrContentType);
        Assert.assertEquals(hdrContentType,"application/xml; charset=UTF-8");

        String hdrContentEncoding = response.header("Content-Encoding");
        System.out.println("Header value is "+ hdrContentEncoding);
        Assert.assertEquals(hdrContentEncoding,"gzip");



    }
}
