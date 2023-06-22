package hello.member.repository;

import hello.member.domain.Member;

import java.util.List;
import java.util.Optional;

public class Test {

    @org.junit.jupiter.api.Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEuqlTo(2);

    }
}
