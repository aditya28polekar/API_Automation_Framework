package api.models.requests.notion.block;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RichText {
    public String type;
    public Text text;
}
