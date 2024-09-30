package com.example.inicial1;

import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.DomicilioRepository;
import com.example.inicial1.repositories.LocalidadRepository;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);

		System.out.println("funcionando");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository, AutorRepository autorRepository, LocalidadRepository localidadRepository) {
		return args -> {
			// Creo un objeto persona
			Persona per1 = Persona.builder().
					nombre("Ignacio").apellido("Fernandez").dni(45448079).
					build();
			Domicilio dom1 = Domicilio.builder().
					calle("San Martin").
					numero(1950).build();

			per1.setDomicilio(dom1);

			Localidad localidad1 = Localidad.builder().denominacion("Guaymallén").build();

			localidadRepository.save(localidad1);
			dom1.setLocalidad(localidad1);

			List<Libro> libros = Arrays.asList(
					Libro.builder()
							.titulo("Cien años de soledad")
							.fecha(1967)
							.genero("Realismo mágico")
							.paginas(417)
							.build(),
					Libro.builder()
							.titulo("El Aleph")
							.fecha(1949)
							.genero("Ficción")
							.paginas(146)
							.build()
			);

			per1.setLibros(libros);

			List<Autor> autores = Arrays.asList(
					Autor.builder()
							.nombre("Gabriel")
							.apellido("García Márquez")
							.biografia("Autor colombiano, conocido por obras como Cien años de soledad.")
							.build(),
					Autor.builder()
							.nombre("Jorge")
							.apellido("Luis Borges")
							.biografia("Escritor argentino, reconocido por sus cuentos y ensayos.")
							.build()
			);

			autores.forEach(autorRepository::save);
			libros.get(0).getAutores().add(autores.get(0));
			libros.get(1).getAutores().add(autores.get(1));

			// Persisto la primera persona
			personaRepository.save(per1);

			// Creo un segundo objeto Persona
			Persona per2 = Persona.builder()
					.nombre("Laura").apellido("Perez").dni(33222444)
					.build();
			Domicilio dom2 = Domicilio.builder()
					.calle("Belgrano")
					.numero(1234)
					.build();


			per2.setDomicilio(dom2);

			Localidad localidad2 = Localidad.builder().denominacion("Maipu").build();
			localidadRepository.save(localidad2);
			dom2.setLocalidad(localidad2);

			List<Libro> libros2 = Arrays.asList(
					Libro.builder()
							.titulo("Rayuela")
							.fecha(1963)
							.genero("Ficción")
							.paginas(600)
							.build(),
					Libro.builder()
							.titulo("El señor de los anillos")
							.fecha(1954)
							.genero("Fantasía")
							.paginas(1178)
							.build()
			);

			per2.setLibros(libros2);

			List<Autor> autores2 = Arrays.asList(
					Autor.builder()
							.nombre("Julio")
							.apellido("Cortázar")
							.biografia("Escritor argentino, autor de Rayuela.")
							.build(),
					Autor.builder()
							.nombre("J.R.R.")
							.apellido("Tolkien")
							.biografia("Escritor británico, creador de El señor de los anillos.")
							.build()
			);

			autores2.forEach(autorRepository::save);
			libros2.get(0).getAutores().add(autores2.get(0));
			libros2.get(1).getAutores().add(autores2.get(1));

			// Persisto la segunda persona
			personaRepository.save(per2);


			// Creo un tercer objeto Persona
			Persona per3 = Persona.builder()
					.nombre("María").apellido("Gonzalez").dni(27889900)
					.build();
			Domicilio dom3 = Domicilio.builder()
					.calle("Sarmiento")
					.numero(2222)
					.build();


			per3.setDomicilio(dom3);

			Localidad localidad3 = Localidad.builder().denominacion("Godoy Cruz").build();
			localidadRepository.save(localidad3);
			dom3.setLocalidad(localidad3);

			List<Libro> libros3 = Arrays.asList(
					Libro.builder()
							.titulo("Crimen y castigo")
							.fecha(1866)
							.genero("Filosofía")
							.paginas(671)
							.build(),
					Libro.builder()
							.titulo("La metamorfosis")
							.fecha(1915)
							.genero("Ficción")
							.paginas(201)
							.build()
			);

			per3.setLibros(libros3);

			List<Autor> autores3 = Arrays.asList(
					Autor.builder()
							.nombre("Fiódor")
							.apellido("Dostoievski")
							.biografia("Escritor ruso, conocido por Crimen y castigo.")
							.build(),
					Autor.builder()
							.nombre("Franz")
							.apellido("Kafka")
							.biografia("Escritor checo, autor de La metamorfosis.")
							.build()
			);

			autores3.forEach(autorRepository::save);

			libros3.get(0).getAutores().add(autores3.get(0));
			libros3.get(1).getAutores().add(autores3.get(1));

			// Persisto la tercera persona
			personaRepository.save(per3);
		};
	}


};


