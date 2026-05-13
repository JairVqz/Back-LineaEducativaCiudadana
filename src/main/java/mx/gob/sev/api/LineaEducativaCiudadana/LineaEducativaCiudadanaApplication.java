package mx.gob.sev.api.LineaEducativaCiudadana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LineaEducativaCiudadanaApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LineaEducativaCiudadanaApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LineaEducativaCiudadanaApplication.class, args);
	}

	

}
 