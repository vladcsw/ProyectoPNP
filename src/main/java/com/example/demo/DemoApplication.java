package com.example.demo;

import com.example.demo.enumeration.Status;
import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.RELACION_PER_EMPRESA;
import com.example.demo.model.Server;
import com.example.demo.repo.DOCUMENTORepo;
import com.example.demo.repo.RELACION_PER_EMPRESARepo;
import com.example.demo.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private Long id;
	private String nombres;
	private String apellidopaterno;
	private String apellidomaterno;
	private Date fecha ;
	private String natural;
	private String estadocivil;
	private String genero;
	private String tipodoc;
	private String numdoc;
	private String departamento;
	private String provincia;
	private String distrito;

	@Bean
	CommandLineRunner run(ServerRepo serverRepo, RELACION_PER_EMPRESARepo a, DOCUMENTORepo documentoRepo) throws ParseException {

		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		Date date = DateFor.parse("05/05/2019");

		return args -> {
			documentoRepo.save(new DOCUMENTO(null,"descripción","asunto","tipoDocumento","codigo", LocalDate.now(), "obtencion", "situacion",1,1,1,1,1,1));



			serverRepo.save(new Server(null, "Juan", "Perez", "Perez", "soltero", "MASCULINO",date, "LIMA", "DNI", "12312312", "AREQUIPA", "AREQUIPA", "AREQUIPA"));
			serverRepo.save(new Server(null, "Pedro", "Diaz", "Diaz", "soltero", "MASCULINO", date, "LIMA","DNI", "12312312", "AREQUIPA", "AREQUIPA", "AREQUIPA"));
			//serverRepo.save(new Server(null, "Juan", "Perez", "Perez"));
			a.save(new RELACION_PER_EMPRESA(null, "Director"));
			a.save(new RELACION_PER_EMPRESA(null, "Secretario"));

		};
	}


	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
