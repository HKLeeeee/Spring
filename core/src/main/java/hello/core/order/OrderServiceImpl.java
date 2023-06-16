package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscoutnPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    //    private final DiscountPolicy discountPolicy = new FixDiscoutnPolicy();
    //    -> 할인 정책을 바꾸려면 클라이언트의 코드를 고쳐야한다. OCP 위반!
    //    인터페이스에도 의존하고, 구현체에도 의존하고 있기 때문!!  DIP 위반
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private  DiscountPolicy discountPolicy; // 인터페이스에만 의존 -> DI Dependency Injection!

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
