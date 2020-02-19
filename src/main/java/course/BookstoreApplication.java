package course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import course.domain.Author;
import course.domain.AuthorRepository;
import course.domain.Book;
import course.domain.BookRepository;
import course.domain.User;
import course.domain.UserRepository;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository srepository, AuthorRepository arepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			arepository.save(new Author("Author1"));
			arepository.save(new Author("Author2"));
			arepository.save(new Author("Author3"));
			
			srepository.save(new Book("Title", arepository.findByName("Author1").get(0), "1987", "938892", "90.00"));
			srepository.save(new Book("Title2", arepository.findByName("Author3").get(0), "isnb3", "1876", "98.00"));
			
			log.info("fetch all students");
			for (Book books : srepository.findAll()) {
				log.info(books.toString());
			}

		};
	}
}
