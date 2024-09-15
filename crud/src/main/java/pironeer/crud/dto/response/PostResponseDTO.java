package pironeer.crud.dto.response;

import lombok.Builder;
import lombok.Getter;
import pironeer.crud.repository.domain.Post;

import java.time.LocalDateTime;

@Getter
public class PostResponseDTO {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String loginId;

    @Builder
    public PostResponseDTO(Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.loginId = post.getMember().getLoginId();
    }
}
