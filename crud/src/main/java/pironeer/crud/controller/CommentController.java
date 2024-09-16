package pironeer.crud.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pironeer.crud.dto.reqeust.CommentWriteRequestDTO;
import pironeer.crud.dto.response.CommentResponseDTO;
import pironeer.crud.dto.response.MemberResponseDTO;
import pironeer.crud.service.comment.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/write")
    public ResponseEntity<Long> write(@RequestBody CommentWriteRequestDTO commentWriteRequestDTO, HttpSession session){
        MemberResponseDTO memberResponseDTO = (MemberResponseDTO) session.getAttribute("user");
        Long commentId = commentService.writeComment(commentWriteRequestDTO, memberResponseDTO.getLoginId());
        return ResponseEntity.ok(commentId);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentResponseDTO>> showCommentList(@PathVariable ("postId") Long postId){
        List<CommentResponseDTO> commentList = commentService.showCommentList(postId);
        return ResponseEntity.ok(commentList);
    }
}
