package hello.advanced.treadlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceId;
import hello.advanced.treadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldServiceTest {
	private FieldService fieldService = new FieldService();

	@Test
	void field(){
		log.info("main start");
		Runnable userA = () -> {
			fieldService.logic("userA");
		};
		Runnable userB = () -> fieldService.logic("userB");

		Thread threadA = new Thread(userA);
		threadA.setName("A");
		Thread threadB = new Thread(userB);
		threadB.setName("B");

		threadA.start();
		fieldService.sleep(2000);
		threadB.start();
		fieldService.sleep(2000);
	}

	@Test
	void field2(){
		log.info("main start");
		Runnable userA = () -> {
			fieldService.logic("userA");
		};
		Runnable userB = () -> fieldService.logic("userB");

		Thread threadA = new Thread(userA);
		threadA.setName("A");
		Thread threadB = new Thread(userB);
		threadB.setName("B");

		threadA.start();
		fieldService.sleep(20);
		threadB.start();
		fieldService.sleep(2000);
	}
}
