package api.models.responses.notion.databases;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Parent {
    public String type;
    public String database_id;
}
