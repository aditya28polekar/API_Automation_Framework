package api.models.responses.chatgpt.completion;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Choice{
    public int index;
    public Message message;
    public Object logprobs;
    public String finish_reason;
}