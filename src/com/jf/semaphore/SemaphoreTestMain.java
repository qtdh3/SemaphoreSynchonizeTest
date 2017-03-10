package com.jf.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import System.out.SemaphorePrintThread;

public class SemaphoreTestMain {

	public static void main(String[] args) {
		System.out.println("主线程入口");
		
		Semaphore semaphore=new Semaphore(1, true);
		AtomicInteger countNum=new AtomicInteger(1);
		
		SemaphorePrintThread threadA=new SemaphorePrintThread(countNum, semaphore, "线程A");
		SemaphorePrintThread threadB=new SemaphorePrintThread(countNum, semaphore, "线程B");
		SemaphorePrintThread threadC=new SemaphorePrintThread(countNum, semaphore, "线程C");
		threadA.start();
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadB.start();
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadC.start();
	}

}
