package com.pironeer.week3.member.service;

import com.pironeer.week3.global.dto.response.JwtTokenSet;
import com.pironeer.week3.global.dto.response.result.SingleResult;
import com.pironeer.week3.global.exception.CustomException;
import com.pironeer.week3.global.exception.ErrorCode;
import com.pironeer.week3.global.service.AuthService;
import com.pironeer.week3.global.service.ResponseService;
import com.pironeer.week3.member.dto.request.MemberCreateRequest;
import com.pironeer.week3.member.dto.request.MemberLoginRequest;
import com.pironeer.week3.member.entity.Member;
import com.pironeer.week3.member.mapper.MemberMapper;
import com.pironeer.week3.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final AuthService authService;

    public SingleResult<JwtTokenSet> register(MemberCreateRequest request){
        //아이디 중복 체크
        if(memberRepository.existByMemberId(request.memberId())){
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }

        Member newMember = memberRepository.save(MemberMapper.from(request));

        JwtTokenSet jwtTokenSet = authService.generateToken(newMember.getId());
        return ResponseService.getSingleResult(jwtTokenSet);
    }

    public SingleResult<JwtTokenSet> login(MemberLoginRequest request){
        Member member = memberRepository.findByMemberId(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        //비밀번호 검증
        if(!member.getPassword().equals(request.password())){
            throw new CustomException(ErrorCode.USER_WRONG_PASSWORD);
        }

        JwtTokenSet jwtTokenSet = authService.generateToken(member.getId());
        return ResponseService.getSingleResult(jwtTokenSet);
    }
}
