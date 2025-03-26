package com.asus.Insurance.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the ModelMapper bean for dependency injection.
 * ModelMapper is used to simplify object mapping between DTOs and domain entities
 * (e.g., mapping API request payloads to internal data models).
 */

@Configuration
public class Modelmapper {
	
	/**
     * Creates a singleton ModelMapper instance managed by the Spring container.
     * This bean can be autowired into services/controllers to perform object conversions.
     * 
     * @return A new instance of ModelMapper with default configurations.
     */
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
