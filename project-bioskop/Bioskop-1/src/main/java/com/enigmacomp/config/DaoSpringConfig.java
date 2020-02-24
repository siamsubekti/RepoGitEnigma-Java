package com.enigmacomp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.enigmacomp.Impl.TransaksiImpl;
import com.enigmacomp.service.TransaksiService;

@Configuration
public class DaoSpringConfig {
	@Bean
	@Primary
	public TransaksiService transaksiService() {
		return new TransaksiImpl();
	}
}
