package com.dy.sdata;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dy.sdata.entities.Book;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class)){
			BookService service = context.getBean(BookService.class);
			Book book = new Book("First book", new Date(), 33, new BigDecimal("26.60"));
			service.save(book);
		}
		

	}

}
