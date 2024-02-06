package hello.advanced.app.v0;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceV0 {
	private final OrderRepositoryV0 orderRepository;

	public void orderItem(String itemId) {
		log.info("OrderServiceV0.orderItem");
		orderRepository.save(itemId);
	}


}
