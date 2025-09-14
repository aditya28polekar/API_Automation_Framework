package api.services.chatgpt;

import api.filters.LoggingAndReportingFilter;
import api.services.BaseService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChatGptBaseService extends BaseService {

    private static final String CHAT_GPT_BASE_URI = "https://api.openai.com/v1";
    private RequestSpecification requestSpecification;


    protected ChatGptBaseService(){
        requestSpecification = RestAssured.given().baseUri(CHAT_GPT_BASE_URI);
    }

    protected Response postRequest(String endpoint , Object payload , String token){
        return requestSpecification.contentType(ContentType.JSON).header("Authorization" , token).body(payload).post(endpoint);
    }
}
