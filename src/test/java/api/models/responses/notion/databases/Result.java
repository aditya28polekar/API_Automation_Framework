package api.models.responses.notion.databases;

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
    public Date created_time;
    public Date last_edited_time;
    public CreatedBy created_by;
    public LastEditedBy last_edited_by;
    public Object cover;
    public Object icon;
    public Parent parent;
    public boolean archived;
    public boolean in_trash;
    public boolean is_locked;
    public Properties properties;
    public String url;
    public Object public_url;
}
