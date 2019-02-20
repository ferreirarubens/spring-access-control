package com.ferreirarubens.accesscontrol.common.config.data;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@Configuration
public class DatabaseConfig {
	/*@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}*/
}
