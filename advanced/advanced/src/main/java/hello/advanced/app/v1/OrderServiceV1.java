package hello.advanced.app.v1;

import org.springframework.stereotype.Service;

import hello.advanced.trace.helloTrace.HelloTraceV2;
import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceV1 {
	private final OrderRepositoryV1 orderRepository;
	private final HelloTraceV2 trace;

	public void orderItem(TraceId traceId, String itemId) {

		TraceStatus status = null;
		try {
			status = trace.beginSync(traceId, "OrderService.orderItem()");
			orderRepository.save(status.getTraceId(), itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}

	}
}
