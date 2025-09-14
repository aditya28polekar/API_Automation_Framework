package api.models.responses.notion.block;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RichText {
    public String type;
    public Text text;
    public Annotations annotations;
    public String plain_text;
    public Object href;
}
