package api.models.responses.notion.databases;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatabaseResponse{
    public String object;
    public ArrayList<Result> results;
    public Object next_cursor;
    public boolean has_more;
    public String type;
    public PageOrDatabase page_or_database;
    public String developer_survey;
    public String request_id;
}



