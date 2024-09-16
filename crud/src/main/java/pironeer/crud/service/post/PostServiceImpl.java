package pironeer.crud.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pironeer.crud.dto.reqeust.PostUpdateRequestDTO;
import pironeer.crud.dto.reqeust.PostWriteRequestDTO;
import pironeer.crud.dto.response.PostResponseDTO;
import pironeer.crud.repository.MemberRepository;
import pironeer.crud.repository.PostRepository;
import pironeer.crud.repository.domain.Member;
import pironeer.crud.repository.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Override
    public Long savePost(PostWriteRequestDTO postWriteRequestDTO, String loginId) {
        Member member = memberRepository.findByLoginId(loginId);
        Post post = Post.builder()
                .title(postWriteRequestDTO.getTitle())
                .content(postWriteRequestDTO.getContent())
                .member(member)
                .build();
        postRepository.save(post);
        return post.getPostId();
    }

    @Override
    public PostResponseDTO readPost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        PostResponseDTO postResponseDTO = PostResponseDTO.builder()
                .post(post.get())
                .build();
        return postResponseDTO;
    }

    @Override
    public List<PostResponseDTO> showPostList() {
        List<Post> all = postRepository.findAll();
        List<PostResponseDTO> postList = new ArrayList<>();

        for(Post post : all){
            PostResponseDTO build = PostResponseDTO.builder()
                    .post(post)
                    .build();
            postList.add(build);
        }
        return postList;
    }

    @Override
    public PostResponseDTO updatePost(PostUpdateRequestDTO postUpdateRequestDTO, String loginId) {
        Optional<Post> post = postRepository.findById(postUpdateRequestDTO.getPostId());
        Post updatedPost = post.get();
        if(updatedPost.getMember().getLoginId().equals(loginId)){
            updatedPost.update(postUpdateRequestDTO.getTitle(),postUpdateRequestDTO.getContent());
            postRepository.save(updatedPost);
            return PostResponseDTO.builder()
                    .post(updatedPost)
                    .build();
        }
        return null;
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
