package com.baris.ertas.LibraryApplicaton;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.model.User;
import com.baris.ertas.LibraryApplicaton.repository.AuthorRepository;
import com.baris.ertas.LibraryApplicaton.repository.BookRepository;
import com.baris.ertas.LibraryApplicaton.repository.PublisherRepository;
import com.baris.ertas.LibraryApplicaton.service.UserServiceImpl;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@EnableEncryptableProperties
@SpringBootApplication
public class LibraryApplicatonApplication {

	public static Logger logger = LoggerFactory.getLogger(LibraryApplicatonApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplicatonApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, UserServiceImpl userServiceImpl) {

		return args -> {

			User adminUser = new User("admin", "admin123", "admin123@gmail.com",new HashSet<>());

			userServiceImpl.saveAdmin(adminUser);

			Author author = new Author("yazar1", "yazar1_tanim ");
			Publisher publisher = new Publisher("1 yayinlari", "1 yayinlari_tanim");

			publisherRepository.save(publisher);
			authorRepository.save(author);

			Book book = new Book("Kitap1", "Kitap1 alt basik",
					"kitap1_seri_adi", "1", "kitap1_tanim", author, publisher);
			Book book2 = new Book("Kitap2", "Kitap2 alt basik", "kitap2_seri_adi", "2", "kitap2_tanim", author, publisher);
			Book book3 = new Book("Kitap3", "Kitap3 alt basik", "kitap3_seri_adi", "3", "kitap3_tanim", author, publisher);
			Book book4 = new Book("Kitap4", "Kitap4 alt basik", "kitap4_seri_adi", "4", "kitap4_tanim", author, publisher);
			Book book5 = new Book("Kitap5", "Kitap5 alt basik", "kitap5_seri_adi", "5", "kitap5_tanim", author, publisher);
			Book book6 = new Book("Kitap6", "Kitap6 alt basik", "kitap6_seri_adi", "6", "kitap6_tanim", author, publisher);
			Book book7 = new Book("Kitap7", "Kitap7 alt basik", "kitap7_seri_adi", "7", "kitap7_tanim", author, publisher);

			bookRepository.save(book);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			bookRepository.save(book5);
			bookRepository.save(book6);
			bookRepository.save(book7);
		};
	}
}
