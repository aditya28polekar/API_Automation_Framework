package api.tests.gpt_and_notion;

import api.models.requests.chatgpt.completion.CompletionRequest;
import api.models.requests.chatgpt.completion.Message;
import api.models.requests.notion.block.PatchBlockRequest;
import api.models.responses.chatgpt.completion.CompletionResponse;
import api.models.responses.notion.block.BlockResponse;
import api.models.responses.notion.databases.DatabaseResponse;
import api.models.responses.notion.databases.Result;
import api.services.chatgpt.ChatService;
import api.services.notion.BlockService;
import api.services.notion.DatabaseService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Listeners({api.listners.TestListener.class})
public class ChatGptTextGenerationTest extends BaseTest{



    Map<String,String> mapOfPageToTitle;
    HashMap<String,String> mapOfPageToContent;
    List<String> ListOfPageIDsWhichHasContent;
    DatabaseResponse databaseResponse;
    CompletionResponse completionResponse;



    @Test
    public void getPageListInDatabasesTest(){
        DatabaseService databaseService = new DatabaseService();
        Response res = databaseService.databases("Bearer " + notion_key , databaseId);
        //System.out.println(res.asPrettyString());
        Assert.assertEquals(res.statusCode() , 200);

        databaseResponse = res.as(DatabaseResponse.class);
        //System.out.println(databaseResponse.results.get(0).id);

        mapOfPageToTitle = new HashMap<>();
        for(Result result : databaseResponse.results){
            mapOfPageToTitle.put(result.id , result.properties.name.title.get(0).plain_text);
        }
        //System.out.println("initial map " + mapOfPageToTitle);

    }

    @Test (dependsOnMethods = {"getPageListInDatabasesTest"})
    public void getPageContent(){

        ListOfPageIDsWhichHasContent = new ArrayList<>();

        for(String pageId : mapOfPageToTitle.keySet()) {
            BlockService blockService = new BlockService();
            Response res = blockService.blocks("Bearer " + notion_key, pageId);
            //System.out.println(res.asPrettyString());
            Assert.assertEquals(res.statusCode(), 200);

            BlockResponse blockResponse = res.as(BlockResponse.class);
            //System.out.println(blockResponse.results.get(1).paragraph.rich_text.get(0).plain_text);


            if (blockResponse.results.size() > 0) {
                //System.out.println(blockResponse.results.size() + " , " + mapOfPageToTitle.get(pageId));
                ListOfPageIDsWhichHasContent.add(pageId);
            }
        }

        // now we will remove the pages which already has content

        for(int i = 0 ; i < ListOfPageIDsWhichHasContent.size() ; i++) {
            String KeyToBeRemoved = ListOfPageIDsWhichHasContent.get(i);
            //System.out.println("getting to delete key " + mapOfPageToTitle.get(KeyToBeRemoved));
            mapOfPageToTitle.entrySet()
                    .removeIf(
                            entry -> (KeyToBeRemoved == entry.getKey()));
        }
        //System.out.println("final map " + mapOfPageToTitle);



    }

    @Test(dependsOnMethods = {"getPageContent"})
    public void chat_gptTextGenerationTest(){
        mapOfPageToContent = new HashMap<>();

        String prompt = "\"explain me about {{topic}} in very brief and in a very simple and meaningful terms , and give information in form of paragraphs not in points and response should not any line spaces in it give response in single paragraph";
        for(String pageId : mapOfPageToTitle.keySet()) {
            // serialization
            String local_prompt = prompt.replace("{{topic}}" , mapOfPageToTitle.get(pageId));
            List<Message> messageList = new ArrayList<>();
            Message message = new Message("user", local_prompt);
            messageList.add(message);
            CompletionRequest completionRequest = new CompletionRequest("gpt-4o-mini", messageList);


            ChatService chatService = new ChatService();
            Response res = chatService.completion(completionRequest, "Bearer " + chatgpt_key);
            CompletionResponse completionResponse = res.as(CompletionResponse.class); // De-serialization

            System.out.println(res.asPrettyString());
            System.out.println("fetching response : " + completionResponse.object);
            Assert.assertEquals(res.statusCode(), 200);
            mapOfPageToContent.put(pageId , completionResponse.choices.get(0).message.content);
        }

    }

    @Test (dependsOnMethods = {"chat_gptTextGenerationTest"})
    public void PatchContentToPage(){

        for(String pageId : mapOfPageToContent.keySet()) {
            String filePath = System.getProperty("user.dir") + "//src//test//resources//request_payloads//PatchBlockInPage.json";
            PatchBlockRequest patchBlockRequest = JsonUtil.fromJsonFile(filePath, PatchBlockRequest.class);
            patchBlockRequest.children.get(1).paragraph.rich_text.get(0).text.content = mapOfPageToContent.get(pageId);
            patchBlockRequest.children.get(0).heading_2.rich_text.get(0).text.content = mapOfPageToTitle.get(pageId);
            //System.out.println(patchBlockRequest.children.get(1).paragraph.rich_text.get(0).text.content);

            BlockService blockService = new BlockService();
            Response res = blockService.PatchBlocks("Bearer " + notion_key, patchBlockRequest, pageId);
            //System.out.println(res.asPrettyString());
            Assert.assertEquals(res.statusCode(), 200);


            BlockResponse blockResponse = res.as(BlockResponse.class);
            Assert.assertEquals(blockResponse.results.get(0).heading_2.rich_text.get(0).text.content , mapOfPageToTitle.get(pageId));
            Assert.assertEquals(blockResponse.results.get(1).paragraph.rich_text.get(0).text.content , mapOfPageToContent.get(pageId));
            //Assert.assertEquals(blockResponse.results.get(0).heading_2.rich_text.get(0).text.content , "xyz");

        }




    }
}
