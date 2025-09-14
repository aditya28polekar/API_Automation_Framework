package api.models.responses.notion.block;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result {
    public String object;
    public String id;
    public Parent parent;
    public Date created_time;
    public Date last_edited_time;
    public CreatedBy created_by;
    public LastEditedBy last_edited_by;
    public boolean has_children;
    public boolean archived;
    public boolean in_trash;
    public String type;
    public Heading2 heading_2;
    public Paragraph paragraph;
}
