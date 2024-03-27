package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    // optional : null을 반환하는 방법, java 8 기능
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
