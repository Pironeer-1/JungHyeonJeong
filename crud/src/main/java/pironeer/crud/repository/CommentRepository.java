package pironeer.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pironeer.crud.repository.domain.Comment;
import pironeer.crud.repository.domain.Post;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
