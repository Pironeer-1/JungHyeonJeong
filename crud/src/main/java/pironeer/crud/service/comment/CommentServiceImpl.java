package pironeer.crud.service.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pironeer.crud.dto.reqeust.CommentWriteRequestDTO;
import pironeer.crud.dto.response.CommentResponseDTO;
import pironeer.crud.repository.CommentRepository;
import pironeer.crud.repository.MemberRepository;
import pironeer.crud.repository.PostRepository;
import pironeer.crud.repository.domain.Comment;
import pironeer.crud.repository.domain.Member;
import pironeer.crud.repository.domain.Post;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public Long writeComment(CommentWriteRequestDTO commentWriteRequestDTO, String loginId) {
        Member member = memberRepository.findByLoginId(loginId);
        Optional<Post> post = postRepository.findById(commentWriteRequestDTO.getPostId());
        Optional<Comment> parent;
        if(commentWriteRequestDTO.getParentId() == null){
            parent = Optional.empty();
        }
        else{
            parent = commentRepository.findById(commentWriteRequestDTO.getParentId());
        }

        Comment comment = Comment.builder()
                .content(commentWriteRequestDTO.getContent())
                .member(member)
                .post(post.get())
                .parent(parent.orElse(null))
                .build();
        commentRepository.save(comment);
        return comment.getCommentId();
    }

    @Override
    public List<CommentResponseDTO> showCommentList(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        List<Comment> all = commentRepository.findByPost(post.get());
        List<CommentResponseDTO> commentList = new ArrayList<>();
        Map<Long, CommentResponseDTO> commentHashMap = new HashMap<>();

        for(Comment comment : all) {
            CommentResponseDTO build = CommentResponseDTO.builder()
                    .comment(comment)
                    .build();
            commentHashMap.put(build.getCommentId(), build);

            if(comment.getParent() != null){
                CommentResponseDTO parentDTO = commentHashMap.get(comment.getParent().getCommentId());
                if (parentDTO != null) parentDTO.getChildren().add(build);
            }
            else{
                commentList.add(build);
            }
        }
        return commentList;
    }
}
