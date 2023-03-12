package com.Jasypt.Controller;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Jasypt.Entity.Product;
import com.Jasypt.Repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("product")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@GetMapping("encrypt")
	public String getEncrypt(@RequestParam(name = "encrypt") String value) {
		System.out.println(value);
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
		return encryptor.encrypt(value);
	}
}
