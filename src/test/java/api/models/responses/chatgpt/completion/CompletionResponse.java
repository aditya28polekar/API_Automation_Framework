package api.models.responses.chatgpt.completion;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompletionResponse {
    public String id;
    public String object;
    public int created;
    public String model;
    public ArrayList<Choice> choices;
    public Usage usage;
    public String service_tier;
    public String system_fingerprint;
}
