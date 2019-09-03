package com.uks.jvs.day8.ass2;

/**
 * Date:27/06/2019
 * Assignment: Day 8
 * Task: Runnable interface in Java
 *
 * @author Kailas
 */
public class ThreadDemo2 implements Runnable {
	/**
	 * This method is used to print 5000 number and sleep for every 75iteration
	 */

	public void run() {
		for (int i = 1; i < 5001; i++) {
			try {
				if (i % 75 == 0) {
					Thread.sleep(200);
					System.out.println("thread 2 : wait for 200miliiseconds " + i);
				}
				System.out.println("Thread- 2 "+Thread.currentThread().getName()+" :"+ i);
			} catch (InterruptedException exception) {

			}

		}
	}

}
