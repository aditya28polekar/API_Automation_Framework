package api.models.responses.notion.block;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Annotations {
    public boolean bold;
    public boolean italic;
    public boolean strikethrough;
    public boolean underline;
    public boolean code;
    public String color;
}
