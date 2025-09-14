package api.models.responses.notion.block;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Text {
    public String content;
    public Object link;
}
