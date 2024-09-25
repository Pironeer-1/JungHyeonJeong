package com.pironeer.week3.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record MemberLoginRequest(
        @NotBlank
        @Schema(description = "회원 id", example = "id")
        String memberId,
        @NotBlank
        @Schema(description = "회원 비밀번호", example = "pwd")
        String password
) {
}
