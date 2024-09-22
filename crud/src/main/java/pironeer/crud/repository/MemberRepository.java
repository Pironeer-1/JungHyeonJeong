package pironeer.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pironeer.crud.repository.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByLoginId(String loginId);
}
