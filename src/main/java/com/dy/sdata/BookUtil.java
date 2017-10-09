package com.dy.sdata;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.dy.sdata.entities.Book;

public class BookUtil {

	public static String[] titles = {
			"book 1",
			"book 2",
			"book 3",
			"book 4",
			"book 5",
			"book 6",
			"book 7",
			"book 8",
			"book 9",
			"book 10",
	};
	
	public static List<Book> create(int size){
		List<Book> books = new LinkedList<Book>();
		for(int i=0; i < size; i++) {
			books.add(BookUtil.create());
		}
		return books;
	}
	
	public static Book create() {
		Book book = new Book();
		book.setTitle(titles[ThreadLocalRandom.current().nextInt(1, titles.length)]);
		book.setPrice(new BigDecimal(ThreadLocalRandom.current().nextInt(10, 1000)));
		book.setPageCount(ThreadLocalRandom.current().nextInt(100, 1000));
		book.setPublishDate(new Date());
		return book;
	}
}
