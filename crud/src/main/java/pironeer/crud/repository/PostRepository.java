package pironeer.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pironeer.crud.repository.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
