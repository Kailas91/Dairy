package com.uks.jvs.day8.ass2;

/**
 * Date:27/06/2019
 * Assignment: Day 8
 * Task: Thread in Java
 *
 * @author Kailas
 */
public class ThreadDemo1 extends Thread {

	/**
	 * This method is used to print 5000 number and sleep for every 50 iteration
	 */
	public void run(){
		for(int i=1;i<5001;i++){
			try {
				if (i % 50 == 0) {
					Thread.sleep(100);
					System.out.println("thread 1 :wait for 100 miliiseconds " + i);
				}
				System.out.println("Thread- 1 "+getName()+" :"+ i);

			} catch (InterruptedException ewception) {

			}

		}
	}

}
