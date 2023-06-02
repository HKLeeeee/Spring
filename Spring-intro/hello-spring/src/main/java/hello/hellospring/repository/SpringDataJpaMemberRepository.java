package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
    //JPQL select m from MEmber m where m.name = ?

//    Optional<Member> findByNameAndId(String name, Long Id); 이런식으로 메서드 이름 구성 가능
}
