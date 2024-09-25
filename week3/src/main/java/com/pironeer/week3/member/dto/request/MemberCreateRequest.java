package com.pironeer.week3.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record MemberCreateRequest(
        @NotBlank
        @Schema(description = "회원 id", example = "id")
        String memberId,
        @NotBlank
        @Schema(description = "회원 비밀번호", example = "pwd")
        String password,
        @NotBlank
        @Schema(description = "회원 이름", example = "정현정")
        String name
) {
}
