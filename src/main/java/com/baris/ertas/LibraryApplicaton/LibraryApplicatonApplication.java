package com.baris.ertas.LibraryApplicaton;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.model.User;
import com.baris.ertas.LibraryApplicaton.repository.AuthorRepository;
import com.baris.ertas.LibraryApplicaton.repository.BookRepository;
import com.baris.ertas.LibraryApplicaton.repository.PublisherRepository;
import com.baris.ertas.LibraryApplicaton.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LibraryApplicatonApplication {

	public static Logger logger = LoggerFactory.getLogger(LibraryApplicatonApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplicatonApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, UserServiceImpl userServiceImpl) {

		return args -> {

			User adminUser = new User("admin", "admin123", new HashSet<>());

			userServiceImpl.saveAdmin(adminUser);

			Author author = new Author("Schopenhauer", "alman felsefeci");
			Publisher publisher = new Publisher("can yayinlari", "bura can yayinlari");

			publisherRepository.save(publisher);
			authorRepository.save(author);

			/*Book book = new Book("Olumun anlami", "hayatin subtitle",
					"can yayinlari", "88888", "hayatin anlami hakkinda", author, publisher);

			Book book2 = new Book("Hayatin anlami", "hayatin subtitle", "felsefe serisi", "Schopenhauer",
					"can yayinlari", "77777", "hayatin anlami hakkinda", author, publisher);


			bookRepository.save(book);
			bookRepository. save(book2); */

		};
	}
}
