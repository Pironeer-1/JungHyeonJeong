package pironeer.crud.dto.reqeust;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PostUpdateRequestDTO {
    private String title;
    private String content;
    private Long postId;
}
