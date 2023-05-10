package Giorno6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRunnable2 implements Runnable {
	
	private Logger log = LoggerFactory.getLogger(TestRunnable2.class);
	private String message;

	public TestRunnable2(String message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				log.info("N." + i + " - " + message);
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

}