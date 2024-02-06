package hello.advanced.app.v0;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@RequiredArgsConstructor
public class OrderRepositoryV0 {

	public void save(String itemId){
		log.info("OrderRepositoryV0.save");
		if (itemId.equals("ex")){
			throw new IllegalStateException("예외 발생");
		}
		sleep(1000);

	}

	public void sleep(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}
