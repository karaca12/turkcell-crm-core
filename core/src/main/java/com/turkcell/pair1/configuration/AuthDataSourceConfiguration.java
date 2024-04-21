package com.turkcell.pair1.configuration;

import com.turkcell.pair1.entity.Role;
import com.turkcell.pair1.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.turkcell.pair1.repository",
        entityManagerFactoryRef = "authEntityManagerFactory",
        transactionManagerRef = "authTransactionManager"
)
public class AuthDataSourceConfiguration {
    @Primary
    @Bean(name = "authDataSource")
    public DataSource authDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/auth_service")
                .username("postgres")
                .password("test")
                .build();
    }

    @Primary
    @Bean(name = "authEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean authEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("authDataSource") DataSource authDataSource) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("jakarta.persistence.validation.mode", "auto");
        return builder
                .dataSource(authDataSource)
                .packages("com.turkcell.pair1.entity")
                .properties(properties)
                .persistenceUnit("auth")
                .build();
    }

    @Primary
    @Bean(name = "authTransactionManager")
    public PlatformTransactionManager authTransactionManager(
            @Qualifier("authEntityManagerFactory") LocalContainerEntityManagerFactoryBean authEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(authEntityManagerFactory.getObject()));
    }
}
