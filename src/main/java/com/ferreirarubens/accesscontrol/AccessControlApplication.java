package com.ferreirarubens.accesscontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EnableEurekaClient
public class AccessControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessControlApplication.class, args);
	}
}
