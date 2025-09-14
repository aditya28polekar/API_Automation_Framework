package api.models.requests.notion.block;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Child {
    public String object;
    public String type;
    public Heading2 heading_2;
    public Paragraph paragraph;
}
