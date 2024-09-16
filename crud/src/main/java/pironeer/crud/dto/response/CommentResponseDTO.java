package pironeer.crud.dto.response;

import lombok.Builder;
import lombok.Getter;
import pironeer.crud.repository.domain.Comment;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDTO {
    private String loginId;
    private String content;
    private LocalDateTime createdAt;

    @Builder
    public CommentResponseDTO(Comment comment){
        this.loginId = comment.getMember().getLoginId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
    }
}
