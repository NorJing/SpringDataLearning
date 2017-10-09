package com.dy.sdata;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dy.sdata.entities.Book;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
//		BookService service = context.getBean(BookService.class);
//		Book book = new Book("First book", new Date(), 33, new BigDecimal("26.60"));
//		service.save(book);
		
		BookRepository bookRepository = context.getBean(BookRepository.class);
		
		// Book book = bookRepository.findOne(1L);
		// List<Book> books = bookRepository.findAll();
		
		List<Book> books = BookUtil.create(5);		
		bookRepository.save(books);

		books = bookRepository.findAll();
		for(Book book1:books) {
			if(book1.getBookId().equals(new Long("10"))){
				book1.setTitle("book 10th");
				book1.setPageCount(100000);
			}
			System.out.println(book1);
		}
		
	}

}
