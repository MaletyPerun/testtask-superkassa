package com.example.superkassa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.h2.tools.Server;


import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Profile("Dev")
    @Bean(initMethod = "start", destroyMethod = "stop")
    Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
