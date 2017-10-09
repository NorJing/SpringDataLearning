package com.dy.sdata;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dy.sdata.entities.Book;

public class Application {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//		BookService service = context.getBean(BookService.class);
//		Book book = new Book("First book", new Date(), 33, new BigDecimal("26.60"));
//		service.save(book);
		
		BookRepository bookRepository = context.getBean(BookRepository.class);
		
		// Book book = bookRepository.findOne(1L);
		
		List<Book> books = bookRepository.findAll();
		
		for(Book book:books) {
			System.out.println(book);
		}
		
	}

}
