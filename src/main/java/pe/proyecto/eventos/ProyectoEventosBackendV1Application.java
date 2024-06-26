package pe.proyecto.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProyectoEventosBackendV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEventosBackendV1Application.class, args);
	}

}
