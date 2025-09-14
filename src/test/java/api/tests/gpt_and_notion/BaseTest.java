package api.tests.gpt_and_notion;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected String notion_key;
    protected String chatgpt_key;
    protected String databaseId;

    @BeforeMethod
    @Parameters({"gpt_key","notion_key","database_id"})
    public void setup(String gpt_key , String notion_key , String database_id){
        this.notion_key = notion_key;
        this.chatgpt_key = gpt_key;
        this.databaseId = database_id;
    }

}
