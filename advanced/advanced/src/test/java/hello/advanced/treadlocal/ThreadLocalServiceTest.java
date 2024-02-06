package hello.advanced.treadlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.treadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalServiceTest {
	private final ThreadLocalService threadLocalService = new ThreadLocalService();

	@Test
	void field(){
		log.info("main start");
		Runnable userA = () -> {
			threadLocalService.logic("userA");
		};
		Runnable userB = () -> threadLocalService.logic("userB");

		Thread threadA = new Thread(userA);
		threadA.setName("A");
		Thread threadB = new Thread(userB);
		threadB.setName("B");

		threadA.start();
		threadLocalService.sleep(2000);
		threadB.start();
		threadLocalService.sleep(2000);
	}

	@Test
	void field2(){
		log.info("main start");
		Runnable userA = () -> {
			threadLocalService.logic("userA");
		};
		Runnable userB = () -> threadLocalService.logic("userB");

		Thread threadA = new Thread(userA);
		threadA.setName("A");
		Thread threadB = new Thread(userB);
		threadB.setName("B");

		threadA.start();
		threadLocalService.sleep(20);
		threadB.start();
		threadLocalService.sleep(2000);
	}
}
