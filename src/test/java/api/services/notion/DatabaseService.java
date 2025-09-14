package api.services.notion;

import api.models.requests.chatgpt.completion.CompletionRequest;
import io.restassured.response.Response;

public class DatabaseService extends NotionBaseService{
    private static final String BASE_PATH = "/databases";

    public Response databases(String key , String databaseId){
        return postRequest(BASE_PATH + "/"+ databaseId + "/query"  , "" , key);
    }
}
