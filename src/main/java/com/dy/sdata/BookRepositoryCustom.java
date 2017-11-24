package com.dy.sdata;

import com.dy.sdata.entities.Book;

public interface BookRepositoryCustom {

	public void saveAndLog(Book book);
}
