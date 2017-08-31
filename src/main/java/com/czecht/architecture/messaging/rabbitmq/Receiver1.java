package com.czecht.architecture.messaging.rabbitmq;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

@Component
public class Receiver1 {

	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {
		System.out.println("Receiver1 <" + message + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
