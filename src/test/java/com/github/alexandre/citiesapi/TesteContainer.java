package com.github.alexandre.citiesapi;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.spock.Testcontainers;

import java.io.IOException;

@Testcontainers
public class TesteContainer {


    @Container
    final private static PostgreSQLContainer postgresContainer = new PostgreSQLContainer()

            .withDatabaseName("postgres")
            .withUsername("postgres")
            .withPassword("postgres123");


    @BeforeClass
    public static void init() throws IOException, InterruptedException {
        postgresContainer.start();
        int port = postgresContainer.getFirstMappedPort();
        System.setProperty("spring.datasource.url", String.format("jdbc:postgresql://192.168.0.12:%d/postgres", postgresContainer.getFirstMappedPort()));
        // ...
    }




    @AfterClass
    public static void shutdown() {
        postgresContainer.stop();
    }

}
