package pironeer.crud.service;

import pironeer.crud.dto.reqeust.MemberFormDTO;
import pironeer.crud.dto.response.MemberResponseDTO;

import java.util.List;

public interface MemberService {
    Long join(MemberFormDTO memberFormDTO);
    List<MemberResponseDTO> showMemberList();
    MemberResponseDTO findByLoginId(String loginId, String password);
}
