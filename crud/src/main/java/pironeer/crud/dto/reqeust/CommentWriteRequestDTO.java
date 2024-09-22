package pironeer.crud.dto.reqeust;

import lombok.Data;

@Data
public class CommentWriteRequestDTO {
    private Long postId;
    private Long parentId;
    private String content;
}
