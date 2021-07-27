package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ServletComponentScan
public class RancoApplication {

	private static final Logger log = LoggerFactory.getLogger(RancoApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RancoApplication.class, args);
	}
}
