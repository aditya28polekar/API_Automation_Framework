package api.services.chatgpt;

import api.models.requests.chatgpt.completion.CompletionRequest;
import io.restassured.response.Response;

public class ChatService extends ChatGptBaseService{
    private static final String BASE_PATH = "/chat";

    public Response completion(CompletionRequest payload , String key){
        return postRequest(BASE_PATH + "/completions"  , payload , key);
    }
}
