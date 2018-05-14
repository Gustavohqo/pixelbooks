package br.com.pixelbooks.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.pixelbooks.app")
public class PixelbooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixelbooksApplication.class, args);
	}
}
