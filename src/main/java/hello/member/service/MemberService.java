package hello.member.service;

import hello.member.domain.Member;
import hello.member.repository.MemberRepository;
import hello.member.repository.MemoryMemberRepository;


import java.util.List;
import java.util.Optional;




public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */

    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(member1 -> {
                            throw new IllegalStateException("이미 존재하는 회원");
                        });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);

    }
}

