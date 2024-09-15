package pironeer.crud.service;

import pironeer.crud.dto.reqeust.PostUpdateRequestDTO;
import pironeer.crud.dto.reqeust.PostWriteRequestDTO;
import pironeer.crud.dto.response.PostResponseDTO;

import java.util.List;

public interface PostService {
    Long savePost(PostWriteRequestDTO postWriteRequestDTO, String loginId);
    PostResponseDTO readPost(Long postId);
    List<PostResponseDTO> showPostList();
    PostResponseDTO updatePost(PostUpdateRequestDTO postUpdateRequestDTO, String loginId);
    void deletePost(Long postId);
}
