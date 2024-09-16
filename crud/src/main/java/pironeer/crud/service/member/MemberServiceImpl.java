package pironeer.crud.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pironeer.crud.dto.reqeust.MemberFormDTO;
import pironeer.crud.dto.response.MemberResponseDTO;
import pironeer.crud.repository.MemberRepository;
import pironeer.crud.repository.domain.Member;
import pironeer.crud.service.member.MemberService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;


    @Override
    public Long join(MemberFormDTO memberFormDTO) {
        Member member = Member.builder()
                        .loginId(memberFormDTO.getLoginId())
                                .password(memberFormDTO.getPassword())
                                        .name(memberFormDTO.getName())
                                                .build();
        return memberRepository.save(member).getMemberId();
    }

    @Override
    public List<MemberResponseDTO> showMemberList() {
        //현재 Member 객체를 저장하고 있으므로 dto 형식에 맞게 바꿔서 전달 필요
        List<Member> all = memberRepository.findAll();
        List<MemberResponseDTO> memberList = new ArrayList<>();

        for (Member tmp : all) {
            MemberResponseDTO build = MemberResponseDTO.builder()
                    .member(tmp)
                    .build();
            memberList.add(build);
        }

        return memberList;
    }

    @Override
    public MemberResponseDTO findByLoginId(String loginId, String password) {
        Member member = memberRepository.findByLoginId(loginId);
        if(member != null && member.getPassword().equals(password)){
            return MemberResponseDTO.builder()
                    .member(member)
                    .build();
        }
        return null;
    }
}
