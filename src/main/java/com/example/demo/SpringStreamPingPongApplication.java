package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringStreamPingPongApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStreamPingPongApplication.class, args);
	}

    @Bean
    public Consumer<String> ping() {
        return input -> {
            System.out.println("Received: " + input);
            if (input.equals("ping"))
                outQueue.add("pong");
        };
    }
    
    private Queue<String> outQueue = new LinkedList<String>();
    
    @Bean
    public Supplier<String> pong() {
        return () -> {
            return outQueue.poll();
        };
    }

}
