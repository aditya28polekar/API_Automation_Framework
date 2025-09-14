package api.models.responses.notion.block;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Heading2 {
    public ArrayList<RichText> rich_text;
    public boolean is_toggleable;
    public String color;
}
