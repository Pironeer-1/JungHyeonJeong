package com.pironeer.week3.member.mapper;

import com.pironeer.week3.member.dto.request.MemberCreateRequest;
import com.pironeer.week3.member.entity.Member;

public class MemberMapper {
    public static Member from(MemberCreateRequest request){
        return Member.builder()
                .memberId(request.memberId())
                .password(request.password())
                .name(request.name())
                .build();
    }
}
