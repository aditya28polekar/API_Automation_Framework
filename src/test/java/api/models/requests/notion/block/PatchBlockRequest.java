package api.models.requests.notion.block;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatchBlockRequest{
    public ArrayList<Child> children;
}

