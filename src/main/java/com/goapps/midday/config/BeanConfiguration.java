package com.goapps.midday.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.goapps.midday.utitlity.ImageProcessing;

@Configuration
public class BeanConfiguration {

	@Bean
	public ImageProcessing imageProcessingBean() {
		return new ImageProcessing();
	}
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
}
