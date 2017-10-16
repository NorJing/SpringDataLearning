package com.dy.sdata;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dy.sdata.entities.Book;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		// 1. Use BookService to create an entity
//		BookService service = context.getBean(BookService.class);
//		Book book = new Book("First book", new Date(), 33, new BigDecimal("26.60"));
//		service.save(book);
		
		BookRepository bookRepository = context.getBean(BookRepository.class);
		
		// 2. Use repository to find, create, modify, delete entity
		// Book book = bookRepository.findOne(1L);
		// List<Book> books = bookRepository.findAll();
		
		List<Book> books = BookUtil.create(5);		
		bookRepository.save(books);

//		books = bookRepository.findAll();
//		for(Book book1:books) {
//			if(book1.getBookId().equals(new Long("10"))){
//				book1.setTitle("book 10th");
//				book1.setPageCount(100000);
//			}
//			System.out.println(book1);
//		}
		
		// bookRepository.delete(1L);
//		bookRepository.delete(bookRepository.findOne(1L));
		
//		bookRepository.deleteAll();
//		bookRepository.deleteAllInBatch();
		
//		for(Book book:bookRepository.findAll()) {
//			System.out.println(book);
//		}
		
		// Derived query
//		System.out.println(bookRepository.findByTitle("A Tale of Two Cities"));
		
		// String Operations
//		for(Book b:bookRepository.findByTitleContaining("Tale")) {
//			System.out.println(b);
//		}
		
		// Relational Operations
//		for(Book b:bookRepository.findByPageCountBetween(101, 499)) {
//			System.out.println(b);
//		}
		
		// Logical Operations
//		for(Book b:bookRepository.findByTitleNot("Tale")) {
//			System.out.println(b);
//		}
	
		// Date comparasion
//		try {
//			Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse("01/01/1954");
//			Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse("01/01/1955");
//			for(Book b:bookRepository.findByPublishDateBetween(date1, date2)) {
//				System.out.println(b);
//			}
//		}catch(ParseException e) {
//			e.printStackTrace();
//		}
	
		// Ordering result
//		for(Book b:bookRepository.findByTitleContainingOrderByTitleDesc("the")) {
//			System.out.println(b);
//		}
	
//		System.out.println(bookRepository.findTopByOrderByPageCountDesc());
//		System.out.println(bookRepository.findFirstByOrderByPageCountAsc());
//		System.out.println(bookRepository.findOneByOrderByPageCountAsc());
		
//		for(Book b:bookRepository.findTop6ByOrderByPriceDesc()) {
//			System.out.println(b);
//		}
		
//		for(Book b:bookRepository.findTop5ByTitleContainingOrderByPriceAsc("the")) {
//			System.out.println(b);
//		}
		
		// Nested properties
//		for(Book b:bookRepository.findByAuthor_FirstName("John")) {
//			System.out.println(b);
//		}

		// JPQL
//		for(Book b:bookRepository.getBooksThatPageCountLargerThan(500)){
//			System.out.println(b);
//		}
		
		// Named query
		for(Book b:bookRepository.getAllBooks()){
			System.out.println(b);
		}
		
	}
}
