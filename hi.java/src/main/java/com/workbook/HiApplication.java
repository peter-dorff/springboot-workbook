package com.workbook;

import java.util.Hashtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HiApplication {
	
	@RequestMapping("/hi/{name}")
	public Hashtable<String,String> sayHello( @PathVariable("name") String name) {
		Hashtable<String,String> result = new Hashtable<String,String>();
		result.put("greetings","Hallo "+name);
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(HiApplication.class, args);
	}
}
