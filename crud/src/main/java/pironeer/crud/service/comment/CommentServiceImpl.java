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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Comment comment = Comment.builder()
                .content(commentWriteRequestDTO.getContent())
                .member(member)
                .post(post.get())
                .build();
        commentRepository.save(comment);
        return comment.getCommentId();
    }

    @Override
    public List<CommentResponseDTO> showCommentList(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        List<Comment> all = commentRepository.findByPost(post.get());
        List<CommentResponseDTO> commentList = new ArrayList<>();

        for(Comment comment : all){
            CommentResponseDTO build = CommentResponseDTO.builder()
                    .comment(comment)
                    .build();
            commentList.add(build);
        }

        return commentList;
    }
}
