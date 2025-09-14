package api.models.requests.notion.block;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paragraph {
    public ArrayList<RichText> rich_text;
}
