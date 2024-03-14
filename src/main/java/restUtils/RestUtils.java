package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {
    private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayLoad, Map<String,String> headers){
        return RestAssured.given()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayLoad);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("End point is : "+ queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is : "+ queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("End Headers are : "+ queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Request Body is : "+ queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response Status is : "+ response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are : "+ response.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Response Body is : "+ response.getBody());
    }
    public static Response performPost(String endpoint, String requestPayLoad, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endpoint,requestPayLoad,headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endpoint, Map<String, Object> requestPayLoad, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endpoint,requestPayLoad,headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
}
