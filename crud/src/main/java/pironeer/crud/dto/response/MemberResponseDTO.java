package pironeer.crud.dto.response;

import lombok.Builder;
import lombok.Getter;
import pironeer.crud.repository.domain.Member;

@Getter
public class MemberResponseDTO {
    private String loginId;
    private String name;

    @Builder
    public MemberResponseDTO(Member member){
        this.loginId = member.getLoginId();
        this.name = member.getName();
    }
}
