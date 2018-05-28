package br.com.aguiar.merchant.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "br.com.aguiar.merchant.repository")
public class DataBaseConfiguration {
}
