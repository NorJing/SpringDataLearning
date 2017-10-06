package com.dy.sdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.sdata.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookResponsitory repo;
	
	public void save (Book book) {
		this.repo.save(book);
	}
}
