package com.societegenerale.bankaccountsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@EnableJpaRepositories
class BankAccountApplicationTests {

	public static void main(final String[] args) {
		SpringApplication.run(BankAccountApplicationTests.class, args);
	}

}
