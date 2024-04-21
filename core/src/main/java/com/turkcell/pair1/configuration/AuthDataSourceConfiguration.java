package com.turkcell.pair1.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.turkcell.pair1.repository",
        entityManagerFactoryRef = "authEntityManagerFactory"
)
public class AuthDataSourceConfiguration {
    @Bean(name = "authDataSource")
    public DataSource authDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/auth_service")
                .username("postgres")
                .password("test")
                .build();
    }

    @Bean(name = "authEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean authEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("authDataSource") DataSource authDataSource) {
        return builder
                .dataSource(authDataSource)
                .packages("com.turkcell.pair1.entity")
                .persistenceUnit("auth")
                .build();
    }
}
