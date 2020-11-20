package com.baris.ertas.LibraryApplicaton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplicatonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplicatonApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner mappingDemo(AuthorRepository authorRepository, BookRepository bookRepository) {

		return args -> {
			Book book = new Book("Hayatin anlami", "hayatin subtitle", "felsefe serisi", "Schopenhauer",
					"can yayinlari", "88888", "hayatin anlami hakkinda");

			Book book2 = new Book("Hayatin anlami", "hayatin subtitle", "felsefe serisi", "Schopenhauer",
					"can yayinlari", "77777", "hayatin anlami hakkinda");

			bookRepository.save(book);
			bookRepository.save(book2);

			ArrayList<Book> bookList = new ArrayList<>();
			bookList.add(book);
			bookList.add(book2);

			Author author = new Author("schopenhauer", "alman felsefeci", bookList);
			authorRepository.save(author);
			//authorRepository.save(new Author("Schopenhauer", "alman felsefeci", bookList));

		};

	}*/

}
