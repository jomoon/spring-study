package com.hjj.bootjdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class BootJdbcApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(BootJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
    }

    private void showConnection() {
        try {
            Connection connection = dataSource.getConnection();

            // 之前调用会为空
            log.error(dataSource.toString());
            log.error(connection.toString());
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
