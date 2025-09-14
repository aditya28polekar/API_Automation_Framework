package api.models.responses.notion.block;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Parent {
    public String type;
    public String page_id;
}
