package com.example.superkassa.config;

import org.h2.tools.Server;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@TestConfiguration
public class TestConfig {

    @Profile("Dev")
    @Bean(initMethod = "start", destroyMethod = "stop")
    Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
