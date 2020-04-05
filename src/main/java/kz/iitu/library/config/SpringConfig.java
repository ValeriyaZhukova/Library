package kz.iitu.library.config;

import kz.iitu.library.Library;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "kz.iitu.library")
@PropertySource("application.properties")
public class SpringConfig {

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/library")
                .username("root")
                .password("1212")
                .build();
    }

    @Bean
    public Library library()
    {
        return new Library();
    }

}
