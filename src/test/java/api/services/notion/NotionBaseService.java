package api.services.notion;

import api.services.BaseService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class NotionBaseService extends BaseService {
    private static final String NOTION_BASE_URI = "https://api.notion.com/v1";
    private RequestSpecification requestSpecification;

    protected NotionBaseService(){
        requestSpecification = RestAssured.given().baseUri(NOTION_BASE_URI);
    }

    protected Response postRequest(String endpoint , Object payload , String token){
        return requestSpecification.contentType(ContentType.JSON).header("Authorization" , token).header("Notion-Version" , "2022-02-22")
                .body(payload).post(endpoint);
    }
    protected Response getRequest(String endpoint , String token){
        return requestSpecification.header("Authorization" , token).header("Notion-Version" , "2022-02-22")
                .get(endpoint);
    }
    protected Response patchRequest(String endpoint , Object payload , String token){
        return requestSpecification.header("Content-Type", "application/json").header("Authorization" , token).header("Notion-Version" , "2022-02-22")
                .body(payload).when().patch(endpoint);

    }   

}
