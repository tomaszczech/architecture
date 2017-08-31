package com.czecht.architecture.messaging.rabbitmq;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;
	private final Receiver1 receiver1;
	private final ConfigurableApplicationContext context;

	public Runner(Receiver1 receiver1, RabbitTemplate rabbitTemplate,
			ConfigurableApplicationContext context) {
		this.receiver1 = receiver1;
		this.rabbitTemplate = rabbitTemplate;
		this.context = context;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(Application.queueName, "Hello from RabbitMQ!");
		receiver1.getLatch().await(10000, TimeUnit.MILLISECONDS);
		context.close();
	}

}