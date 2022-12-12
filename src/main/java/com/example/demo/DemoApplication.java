package com.example.demo;

import com.example.demo.enumeration.Status;
import com.example.demo.model.*;
import com.example.demo.repo.*;
import com.example.demo.service.ARCHIVOService;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	ARCHIVOService fileService;
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
	CommandLineRunner run(ServerRepo serverRepo, PERSONARepo persona, DOCUMENTO_INMUEBLERepo inmueble, DOCUMENTO_EMPRESARepo empresa, DOCUMENTO_INSUMORepo insumo, DOCUMENTO_ARMARepo arma, DOCUMENTO_CUENTA_BANCARIARepo cuenta, DOCUMENTO_MODALIDADRepo modalidad, DOCUMENTO_AGENDARepo agenda, RELACION_PER_EMPRESARepo a, DOCUMENTORepo documentoRepo) throws ParseException {

		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		Date date = DateFor.parse("05/05/2019");
		//fileService.deleteAll();
		fileService.init();

		return args -> {
			documentoRepo.save(new DOCUMENTO(null,"Documento de Prueba 1","Asunto 1","Tipo de Documento 1","Código 1", LocalDate.now(), "Información 1", "Situación 1","Instructor 1",1,1,1,1,1,1,1,1));
			documentoRepo.save(new DOCUMENTO(null,"Documento de Prueba 2","asunto 2","Tipo de Documento 2","Código 2", LocalDate.now(), "Información 2", "Situación 2","Instructor 2",2,1,1,1,1,1,1,1));

			persona.save(new  PERSONA(null, "Juan", "Rivero", 44, "Divorciado", LocalDate.now().toString(), LocalDate.now().toString(), "53265262", 1, 1, "Estado", "Rivero", "Rivero", LocalDate.now().toString(), 1, 1, 1,1L));
			persona.save(new  PERSONA(null, "Pedro", "Diaz", 25, "Soltero", LocalDate.now().toString(), LocalDate.now().toString(), "62373473", 1, 1, "Estado", "Rivero", "Rivero", LocalDate.now().toString(), 1, 1, 1,1L));
			persona.save(new  PERSONA(null, "Juan", "Sanchez", 53, "Soltero", LocalDate.now().toString(), LocalDate.now().toString(), "72457347", 1, 1, "Estado", "Rivero", "Rivero", LocalDate.now().toString(), 1, 1, 1,1L));
			persona.save(new  PERSONA(null, "Guillermo", "Rivero", 30, "Divorciado", LocalDate.now().toString(), LocalDate.now().toString(), "45347234", 1, 1, "Estado", "Rivero", "Rivero", LocalDate.now().toString(), 1, 1, 1,2L));

			inmueble.save(new DOCUMENTO_INMUEBLE(null, 1L, "Urb. Santa Rosa", "Con frente a la calle 17", 1L, 1L, "1251634", 2L));
			inmueble.save(new DOCUMENTO_INMUEBLE(null, 1L, "Urb. Los Rosales", "Con frente al parque", 1L, 1L, "6237634", 1L));
			inmueble.save(new DOCUMENTO_INMUEBLE(null, 1L, "Av. Dolores", "Con frente al grifo", 1L, 1L, "7347352", 1L));


			empresa.save(new DOCUMENTO_EMPRESA(null, "Empresa Sol Natural IERL",1,1L));
			empresa.save(new DOCUMENTO_EMPRESA(null, "Empresa Poniente IERL",1,1L));
			empresa.save(new DOCUMENTO_EMPRESA(null, "Empresa Gas del Sur IERL",1,1L));

			insumo.save(new DOCUMENTO_INSUMO(null, 1L, "Cocaína", 20, 1L, 1L, 1L));
			insumo.save(new DOCUMENTO_INSUMO(null, 1L, "Marihuana", 11, 1L, 1L, 1L));
			insumo.save(new DOCUMENTO_INSUMO(null, 1L, "Cigarros", 200, 1L, 1L, 1L));

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
