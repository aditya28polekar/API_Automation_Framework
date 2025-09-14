package api.models.requests.chatgpt.completion;

import java.util.List;

public class CompletionRequest {
    public String model;
    public List<Message> messages;

    public CompletionRequest(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Completion{" +
                "model='" + model + '\'' +
                ", messages=" + messages +
                '}';
    }
}
