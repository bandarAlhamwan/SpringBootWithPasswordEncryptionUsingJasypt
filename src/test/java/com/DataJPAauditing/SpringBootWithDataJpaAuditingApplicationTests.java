package com.DataJPAauditing;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;


class SpringBootWithDataJpaAuditingApplicationTests {

	@Test
	public StringEncryptor getSensitiveInfoEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		
		config.setPassword("bandar");  // private - key
		config.setAlgorithm("PBEWithMD5AndDES");  // PBEWITHHMACSHA512ANDAES_256
		config.setKeyObtentionIterations(1000);
		config.setPoolSize(1);
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");  // org.jasypt.salt.RandomSaltGenerator
		config.setStringOutputType("base64");
		encryptor.setConfig(config);
		System.out.println(encryptor.encrypt("H2"));
		return encryptor;
		
	}

	public static void main(String[] args) {
		new SpringBootWithDataJpaAuditingApplicationTests().getSensitiveInfoEncryptor();
	}
}
