package com.uks.jvs.day8.ass2;

/**
 * Date:27/06/2019
 * Assignment: Day 8
 * Task:Test Thread  in Java
 *
 * @author Kailas
 */
public class TestThread {

	public static void main(String args[]){

		ThreadDemo1 objThreadDemo1 = new ThreadDemo1();
		ThreadDemo2 objThreadDemo2 = new ThreadDemo2();

		// start method will run the thread or start the thread
		objThreadDemo1.start();

		// make object of class thread to make it runnable
		Thread objThread = new Thread(objThreadDemo2);
		objThread.start();
	}
}
