package api.models.responses.notion.block;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreatedBy {
    public String object;
    public String id;
}
