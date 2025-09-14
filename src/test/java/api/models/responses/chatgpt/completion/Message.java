package api.models.responses.chatgpt.completion;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message{
    public String role;
    public String content;
    public Object refusal;
    public ArrayList<Object> annotations;
}