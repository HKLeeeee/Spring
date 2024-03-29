package hello.advanced.app.v0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderControllerV0 {
	private final OrderServiceV0 orderService;

	@GetMapping("/v0/request")
	public String request(String itemId) {
		log.info("OrderControllerV0.request");
		orderService.orderItem(itemId);
		return "ok";
	}
}
