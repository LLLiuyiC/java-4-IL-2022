package com.example.java4il2022.week4;

import com.example.java4il2022.week3.day13.aop.advice.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * Spring Boot
 *      1. auto configuration
 *      2. main method
 *      3. actuator
 *      4. embedded tomcat
 *
 *
 *
 *     IOC
 *     constructor injection / setter injection / field injection
 *          ByType
 *          ByName injection  @Qualifier / referenceName
 *     bean scope
 *          default: Singleton
 *          prototype
 *          request
 *          session
 *          global session
 */

@SpringBootApplication
class Day15SpringBootApplication {
    private static Day15Demo d1;
    private static Day15Demo d2;

    @Autowired
    public Day15SpringBootApplication(
            @Qualifier("day15Impl1") Day15Demo d1,
            @Qualifier("day15Impl1") Day15Demo d2
    ) {
        Day15SpringBootApplication.d1 = d1;
        Day15SpringBootApplication.d2 = d2;
    }

    public static void main(String[] args) {
        SpringApplication.run(Day15SpringBootApplication.class, args);
        System.out.println(d1 == d2);
    }
}

@Component
interface Day15Demo { }
@Component
@Scope("prototype")
class Day15Impl1 implements Day15Demo {
    @Override
    public String toString() {
        return "Day15Impl1{}";
    }
}
@Component
class Day15Impl2 implements Day15Demo {
    @Override
    public String toString() {
        return "Day15Impl2{}";
    }
}

/**
 *   server - client - network
 *   tomcat / blocking server
 *   netty  / non-blocking server
 *   rest api
 *   spring MVC (impl rest api)
 *   security (Authentication vs Authorization ..)
 */