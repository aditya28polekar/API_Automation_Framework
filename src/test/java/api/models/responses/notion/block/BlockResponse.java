package api.models.responses.notion.block;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlockResponse{
    public String object;
    public ArrayList<Result> results;
    public Object next_cursor;
    public boolean has_more;
    public String type;
    public Block block;
    public String developer_survey;
    public String request_id;
}


