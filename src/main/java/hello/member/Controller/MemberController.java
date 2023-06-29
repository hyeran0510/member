package hello.member.Controller;


import hello.member.domain.Member;
import hello.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
        private final MemberService memberService;

        @Autowired
        public MemberController(MemberService memberService) {
            this.memberService = memberService;
        }


            @GetMapping(value = "/members/new")   //전달 및 url쳐서 들어가는 건 겟매핑
                    public String createForm() {
                return "member/createMemberForm";
            }

            @PostMapping("/members/new")  //데이터를 폼에 넣어서 전달
            public String create(MemberForm form) {
                Member member = new Member();
                member.setName(form.getName());

                System.out.println(member.getName()); //웹페이지에서 입력한 값 확인하기


                memberService.join(member);

                return "redirect:/";
            }

                @GetMapping("/members")
                public String List(Model model){
                    List<Member> members = memberService.findMembers();
                    model.addAttribute("members", members);
                    return "members/memberList";


                }
        }

    }


