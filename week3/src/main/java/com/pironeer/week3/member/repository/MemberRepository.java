package com.pironeer.week3.member.repository;

import com.pironeer.week3.member.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByMemberId(String memberId);
    Boolean existByMemberId(String memberId);
}
