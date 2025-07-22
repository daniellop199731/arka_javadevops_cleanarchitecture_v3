package com.bancolombia.arka_javadevops_cleanarchitecture_v3;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ArkaJavadevopsCleanarchitectureV3Application.class);
	}

}
