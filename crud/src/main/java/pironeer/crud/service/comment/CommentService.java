package pironeer.crud.service.comment;

import pironeer.crud.dto.reqeust.CommentWriteRequestDTO;
import pironeer.crud.dto.response.CommentResponseDTO;

import java.util.List;

public interface CommentService {
    Long writeComment(CommentWriteRequestDTO commentWriteRequestDTO, String loginId);
    List<CommentResponseDTO> showCommentList(Long postId);
}
