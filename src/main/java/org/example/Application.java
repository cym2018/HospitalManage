package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @description 主类
 */

@SpringBootApplication
public class Application {
    /**
     * @param args 启动参数
     * @description 应用入口
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * @return 数据源
     * @description 读取数据源配置
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    DriverManagerDataSource dataSource() {
        return new DriverManagerDataSource();
    }
}
