package practice.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("save: 저장이 정상적으로 되는지 확인")
    void save() throws Exception {
        // given
        Member member = new Member("hello", 25);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member foundMember = memberRepository.findById(member.getId());
        assertThat(savedMember).isEqualTo(foundMember);
    }

    @Test
    @DisplayName("findAll: 전체 찾기 성공")
    void findAll() throws Exception {
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 20);

        // when
        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members.contains(member1)).isTrue();
        assertThat(members.contains(member2)).isTrue();
    }

}