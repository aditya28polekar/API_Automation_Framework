package api.models.responses.notion.block;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paragraph {
    public ArrayList<RichText> rich_text;
    public String color;
}
