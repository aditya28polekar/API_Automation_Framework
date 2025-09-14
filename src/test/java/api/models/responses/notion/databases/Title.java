package api.models.responses.notion.databases;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Title {
    public String type;
    public Text text;
    public Annotations annotations;
    public String plain_text;
    public Object href;
}
