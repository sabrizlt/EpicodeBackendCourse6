package Giorno6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaProject {

	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(JavaProject.class);
		
		TestThread t1 = new TestThread("Primo Thread");
		TestThread t2 = new TestThread("Secondo Thread");
		Thread22 t3 = new Thread22();
		Thread t4 = new Thread(new TestRunnable2("Primo Thread Runnable"));
		Thread t5 = new Thread(new TestRunnable2("Secondo Thread Runnable"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		log.info("FINE");

	}

}