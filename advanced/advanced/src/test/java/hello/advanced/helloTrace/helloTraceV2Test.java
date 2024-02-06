package hello.advanced.helloTrace;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV2;

class helloTraceV2Test {

	@Test
	void begin_end(){
		HelloTraceV2 trace = new HelloTraceV2();
		TraceStatus status = trace.begin("hello");
		TraceStatus status1 = trace.beginSync(status.getTraceId(), "hello2");
		TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
		trace.end(status2);
		trace.end(status1);
		trace.end(status);
	}

	@Test
	void begin_exception(){
		HelloTraceV2 trace = new HelloTraceV2();
		TraceStatus status = trace.begin("hello");
		TraceStatus status1 = trace.beginSync(status.getTraceId(), "hello2");
		TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
		trace.end(status2);
		trace.end(status1);
		trace.exception(status, new IllegalStateException());
	}
}
