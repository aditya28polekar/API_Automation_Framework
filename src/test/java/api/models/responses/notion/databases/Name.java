package api.models.responses.notion.databases;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Name {
    public String id;
    public String type;
    public ArrayList<Title> title;
}
