package pironeer.crud.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pironeer.crud.repository.domain.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CommentResponseDTO {
    private Long commentId;
    private String loginId;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentResponseDTO> children;

    @Builder
    public CommentResponseDTO(Comment comment){
        this.commentId = comment.getCommentId();
        this.loginId = comment.getMember().getLoginId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.children = new ArrayList<>();
    }

/*    public static CommentResponseDTO of(Comment comment, Map<Long, CommentResponseDTO> commentMap){
        CommentResponseDTO tmp = new CommentResponseDTO();
        tmp.commentId = comment.getCommentId();
        tmp.loginId = comment.getMember().getLoginId();
        tmp.content = comment.getContent();
        tmp.createdAt = comment.getCreatedAt();
        tmp.children = comment.getChildren().stream()
                .map(child -> commentMap.get(child.getCommentId()))
                .collect(Collectors.toList());
        return tmp;
    }*/
}
