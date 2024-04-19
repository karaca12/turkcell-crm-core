package com.turkcell.pair1.annotation;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ComponentScan(basePackages = {"com.turkcell.pair1"})
@EntityScan(basePackages = {"com.turkcell.pair1.entity"})
@EnableJpaRepositories(basePackages = {"com.turkcell.pair1.repository"})
public @interface EnableSecurity {
}
