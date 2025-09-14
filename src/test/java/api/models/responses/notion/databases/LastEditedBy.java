package api.models.responses.notion.databases;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LastEditedBy {
    public String object;
    public String id;
}
