package pironeer.crud.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pironeer.crud.dto.reqeust.PostUpdateRequestDTO;
import pironeer.crud.dto.reqeust.PostWriteRequestDTO;
import pironeer.crud.dto.response.MemberResponseDTO;
import pironeer.crud.dto.response.PostResponseDTO;
import pironeer.crud.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/write")
    public ResponseEntity<?> write(@RequestBody PostWriteRequestDTO postWriteRequestDTO, HttpSession session){
        MemberResponseDTO memberResponseDTO = (MemberResponseDTO) session.getAttribute("user");
        Long postId = postService.savePost(postWriteRequestDTO, memberResponseDTO.getLoginId());
        return ResponseEntity.ok(postId);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDTO> read(@PathVariable ("postId") Long postId){
        PostResponseDTO postResponseDTO = postService.readPost(postId);
        return ResponseEntity.ok().body(postResponseDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<PostResponseDTO>> showPostList(){
        List<PostResponseDTO> postList = postService.showPostList();
        return ResponseEntity.ok(postList);
    }

    @PatchMapping("/update")
    public ResponseEntity<PostResponseDTO> update(@RequestBody PostUpdateRequestDTO postUpdateRequestDTO, HttpSession session){
        MemberResponseDTO user = (MemberResponseDTO) session.getAttribute("user");
        PostResponseDTO postResponseDTO = postService.updatePost(postUpdateRequestDTO, user.getLoginId());
        return ResponseEntity.ok(postResponseDTO);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> remove(@PathVariable ("postId") Long postId){
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}
