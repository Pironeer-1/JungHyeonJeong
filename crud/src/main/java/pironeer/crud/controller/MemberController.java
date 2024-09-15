package pironeer.crud.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pironeer.crud.dto.reqeust.MemberFormDTO;
import pironeer.crud.dto.response.MemberResponseDTO;
import pironeer.crud.service.MemberService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createMemberForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(MemberFormDTO memberFormDTO){
        Long memberId = memberService.join(memberFormDTO);
        return "home";
    }

    @GetMapping("/members")
    public String showMemberList(Model model){
        List<MemberResponseDTO> memberList = memberService.showMemberList();
        model.addAttribute("memberList", memberList);
        return "members/memberList";
    }

    @GetMapping("/members/login")
    public String loginForm(){
        return "members/loginForm";
    }

    @PostMapping("/members/login")
    public String login(MemberFormDTO memberFormDTO, Model model, HttpSession session){
        System.out.println(memberFormDTO);
        MemberResponseDTO memberResponseDTO = memberService.findByLoginId(memberFormDTO.getLoginId(), memberFormDTO.getPassword());
        System.out.println(memberResponseDTO);

        if(memberResponseDTO != null){
            session.setAttribute("user", memberResponseDTO);
            return "redirect:/";
        }
        model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다");
        return "members/loginForm";
    }

    @GetMapping("members/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/members/login";
    }
}
