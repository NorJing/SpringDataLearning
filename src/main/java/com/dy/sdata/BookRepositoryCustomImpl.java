package com.dy.sdata;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dy.sdata.entities.Book;

public class BookRepositoryCustomImpl implements BookRepositoryCustom {

	private static Logger logger = LoggerFactory.getLogger(BookRepositoryCustomImpl.class);
	
	@Autowired
	private EntityManager entityManager;
	
	// @Override
	@Transactional
	@SuppressWarnings("unchecked")
	public void saveAndLog(Book book) {
		// TODO Auto-generated method stub
		logger.debug("Saving the book " + book.toString());
		entityManager.persist(book);
	}

}
