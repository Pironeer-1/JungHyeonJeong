package pironeer.crud.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pironeer.crud.dto.reqeust.MemberFormDTO;
import pironeer.crud.dto.response.MemberResponseDTO;
import pironeer.crud.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/new")
    public ResponseEntity<?> createMember(@RequestBody MemberFormDTO memberFormDTO){
        Long memberId = memberService.join(memberFormDTO);
        return ResponseEntity.ok(memberId);
    }

    @GetMapping("")
    public ResponseEntity<List<MemberResponseDTO>> showMemberList(Model model){
        List<MemberResponseDTO> memberList = memberService.showMemberList();
        return ResponseEntity.ok(memberList);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberFormDTO memberFormDTO, HttpSession session){
        MemberResponseDTO memberResponseDTO = memberService.findByLoginId(memberFormDTO.getLoginId(), memberFormDTO.getPassword());

        if(memberResponseDTO != null){
            session.setAttribute("user", memberResponseDTO);
            return ResponseEntity.ok(memberFormDTO);
        }
        return ResponseEntity.status(401).body("아이디 또는 비밀번호가 잘못되었습니다.");
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}
