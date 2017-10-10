package com.dy.sdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dy.sdata.entities.Book;

@Repository
public interface BookRepository extends ReadOnlyRepository<Book, Long> {

}
