package dev.ghimire.SpringBookAPI;

import dev.ghimire.entities.Book;
import dev.ghimire.repos.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest //Create an application context and all the beans in it BEFORE u actually run your tests
class SpringBookApiApplicationTests {

	@Autowired //Hey spring I need a bean of this type
	BookRepo bookRepo;//Spring Data it can read your interfaces and autogenerate implementation classes

	@Test
	void create_book() {
		Book book = new Book(0,"To kill a Mockingbird","Harper Lee",2,true,0);
		bookRepo.save(book);
		System.out.println(book);
	}
	//@Test
	//void get_book_by_id(){
////		//findby in SPring Data returns an optional
////		//Java varsion of a promisw where it will either contain the object or an error message
////		Book book = bookRepo.findById(1);
////		System.out.println(book);
////	}

	@Test
	void get_books_by_condition(){
		Set<Book> books = bookRepo.findBooksByBookCondition(1);
		System.out.println(books);
	}

	@Test
	void get_books_by_author(){
		Set<Book> books = bookRepo.findBooksByAuthorLike("Frank");
		System.out.println(books);
	}

	@Test
	void get_books_by_book_condition(){
		Set<Book> books = bookRepo.findBooksByBookConditionBetween(1,3);
		System.out.println(books);
	}

}
