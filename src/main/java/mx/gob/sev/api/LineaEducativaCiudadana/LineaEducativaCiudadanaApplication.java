package mx.gob.sev.api.LineaEducativaCiudadana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LineaEducativaCiudadanaApplication extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LineaEducativaCiudadanaApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LineaEducativaCiudadanaApplication.class);
	}

}
 