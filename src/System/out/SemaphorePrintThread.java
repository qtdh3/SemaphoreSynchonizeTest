package System.out;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphorePrintThread extends Thread {
	AtomicInteger countNum;
	Semaphore semaphore;
	String threadName;

	public SemaphorePrintThread(AtomicInteger countNum, Semaphore semaphore,
			String threadName) {
		super();
		this.countNum = countNum;
		this.semaphore = semaphore;
		this.threadName = threadName;
	}

	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(countNum.get()<50){
			try {
				semaphore.acquire();
				print();
				sleep(10);
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void print() {
		System.out.println(threadName + ": " + countNum);
		countNum.incrementAndGet();
	}
}
