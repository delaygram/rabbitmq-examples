package com.delaygram.amqp.eventbusexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventBusExampleApplication {

    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return args -> {
            System.out.println("This app uses Spring Profiles to control its behavior.\n");
            System.out.println("Running hello-world");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=hello-world,sender");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=hello-world,receiver\n");
            System.out.println("Running work-queues");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=work-queues,sender");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=work-queues,receiver\n");
            System.out.println("Running publish-subscribe");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=pub-sub,sender");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=pub-sub,receiver\n");
            System.out.println("Running routing");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=routing,sender");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=routing,receiver\n");
            System.out.println("Running topics");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=topics,sender");
            System.out.println("\tjava -jar target/event-bus-example-2.7.0.jar --spring.profiles.active=topics,receiver\n");


        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new EventBusExampleRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(EventBusExampleApplication.class, args);
    }

}
