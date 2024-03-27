package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
//@Service -> spring bean 자동 설정
// @Component , Service 어노테이션 안에 Component 포함
public class MemberService { //command + shift + T : test class 생성

    private final MemberRepository memberRepository;

    //@Autowired
    // 생성자 주입
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // setter 주입
//    @Autowired
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//        // memberService.setMemberService();
//
//    }

    /**
     * 회원 가입
     */
    public Long join(Member member){
        validateDuplicateMember(member); // control + T : Extract Methods
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        // 중복 회원 x
        /*
        Optional<Member> result = memberRepository.findByName(member.getName()); // command + option + v
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /*
    * 회원 id 별 조회
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
