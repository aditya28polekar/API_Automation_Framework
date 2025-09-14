package api.models.responses.notion.databases;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Properties {
    @JsonProperty("Name")
    public Name name;
}
