package com.oksana.configurations;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {
    @Bean
    JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setSchema("FOTOGALLERY");
        dataSource.setDriverClassName("org.h2.Driver");
        return dataSource;
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("128000KB");
        factory.setMaxRequestSize("128000KB");
        return factory.createMultipartConfig();
    }
}