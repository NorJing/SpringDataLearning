package com.dy.sdata;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

	private static Logger logger = LoggerFactory.getLogger(BookRepositoryCustomImpl.class);
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void saveAndLog(Book book) {
		// logger.debug("The application saves the book entity " + book.toString());
		logger.info("Saving the book entity " + book.toString());
		entityManager.persist(book);
	}

}
