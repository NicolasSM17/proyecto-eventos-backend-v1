package pe.proyecto.eventos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pe.proyecto.eventos.entity.Rol;
import pe.proyecto.eventos.repository.IRolRepository;

@SpringBootApplication
@EnableJpaAuditing
public class ProyectoEventosBackendV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEventosBackendV1Application.class, args);
	}

	@Bean
	public CommandLineRunner runner(IRolRepository rolRepository){
		return args -> {
			if(rolRepository.findByNombre("USER").isEmpty()){
				rolRepository.save(Rol.builder().nombre("USER").build());
			}
		};
	}
}
