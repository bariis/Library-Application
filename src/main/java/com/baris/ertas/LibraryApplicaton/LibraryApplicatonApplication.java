package com.baris.ertas.LibraryApplicaton;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.repository.AuthorRepository;
import com.baris.ertas.LibraryApplicaton.repository.BookRepository;
import com.baris.ertas.LibraryApplicaton.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LibraryApplicatonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplicatonApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {

		return args -> {

			Author author = new Author("schopenhauer", "alman felsefeci");
			Publisher publisher = new Publisher("can yayinlari", "bura can yayinlari");

			publisherRepository.save(publisher);
			authorRepository.save(author);

			Book book = new Book("Olumun anlami", "hayatin subtitle", "felsefe serisi", "Schopenhauer",
					"can yayinlari", "88888", "hayatin anlami hakkinda", author, publisher);

			Book book2 = new Book("Hayatin anlami", "hayatin subtitle", "felsefe serisi", "Schopenhauer",
					"can yayinlari", "77777", "hayatin anlami hakkinda", author, publisher);


			bookRepository.save(book);
			bookRepository.save(book2);

		};
	}
}
