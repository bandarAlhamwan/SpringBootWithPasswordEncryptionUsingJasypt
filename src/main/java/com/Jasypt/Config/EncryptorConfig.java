package com.Jasypt.Config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptorConfig {

	
	// create this Bean to overwrite the detault behavior of Jasypt
	@Bean(name = "jasyptStringEncryptor")
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
}
