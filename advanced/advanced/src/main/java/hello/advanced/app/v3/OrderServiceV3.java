package hello.advanced.app.v3;

import org.springframework.stereotype.Service;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceV3 {
	private final LogTrace trace;
	private final OrderRepositoryV3 orderRepository;

	public void orderItem(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderService.orderItem()");
			orderRepository.save(itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}

	}
}
