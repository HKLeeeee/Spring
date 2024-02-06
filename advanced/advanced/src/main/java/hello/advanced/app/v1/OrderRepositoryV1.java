package hello.advanced.app.v1;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.helloTrace.HelloTraceV2;
import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@RequiredArgsConstructor
public class OrderRepositoryV1 {
	private final HelloTraceV2 trace;

	public void save(TraceId traceId, String itemId) {

		TraceStatus status = null;
		try {
			status = trace.beginSync(traceId, "OrderRepository.save()");

			//저장 로직
			if (itemId.equals("ex")) {
				throw new IllegalStateException("예외 발생!");
			}
			sleep(1000);

			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}

	}
	public void sleep(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}
