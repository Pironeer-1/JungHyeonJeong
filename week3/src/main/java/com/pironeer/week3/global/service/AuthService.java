package com.pironeer.week3.global.service;

import com.pironeer.week3.global.dto.response.JwtTokenSet;
import com.pironeer.week3.global.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtUtil jwtUtil;

    public JwtTokenSet generateToken(Long userIdx){
        String token = jwtUtil.createToken(userIdx);

        JwtTokenSet jwtTokenSet = JwtTokenSet.builder()
                .token(token)
                .build();

        return jwtTokenSet;
    }
}
