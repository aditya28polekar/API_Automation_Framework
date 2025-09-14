package api.services.notion;

import api.models.requests.notion.block.PatchBlockRequest;
import io.restassured.response.Response;

public class BlockService extends NotionBaseService{
    private static final String BASE_PATH = "/blocks";

    public Response blocks(String key , String pageId){
        return getRequest(BASE_PATH + "/"+ pageId + "/children"  , key);
    }
    public Response PatchBlocks(String key , PatchBlockRequest payload , String pageId){
        //System.out.println(payload.toString());
        return patchRequest(BASE_PATH + "/"+ pageId + "/children" , payload , key);
    }

}
