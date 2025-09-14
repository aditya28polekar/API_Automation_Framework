package api.models.responses.chatgpt.completion;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromptTokensDetails{
    public int cached_tokens;
    public int audio_tokens;
}