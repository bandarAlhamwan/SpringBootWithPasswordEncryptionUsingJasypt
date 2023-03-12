package com.Jasypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class SpringBootWithPasswordEncryptionUsingJasyptApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithPasswordEncryptionUsingJasyptApplication.class, args);
		
		// https://github.com/ulisesbocchio/jasypt-spring-boot with the plugin 
		//mvn jasypt:encrypt-value -Djasypt.encryptor.password=H2 -Djasypt.plugin.value=password
		//mvn jasypt:decrypt-value -Djasypt.encryptor.password=H2 -Djasypt.plugin.value=7wf4aEUEYjzo1Sl2FAHshyVGdjwPbsY1MI8XGBHEKnNE4MO31qq4L1dQSiwKQSYy
		// run as -> run configurations -> argument -> vm arguments -> -Djasypt.encryptor.password=H2
		
		
		//spring.datasource.username=DEC(sa)
		//spring.datasource.password=DEC(H2)
		// mvn jasypt:encrypt -Djasypt.plugin.path="file:src/main/resources/application.properties" -Djasypt.encryptor.password=bandar
		// vm options in eclipse - run as -> run configurations -> argument -> vm arguments -> -Djasypt.encryptor.password=bandar
	}

}
