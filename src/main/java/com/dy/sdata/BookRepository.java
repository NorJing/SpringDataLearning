package com.dy.sdata;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dy.sdata.entities.Author;
import com.dy.sdata.entities.Book;

@Repository
public interface BookRepository extends BaseRepository<Book, Long> {
	
	// String Operations
	
//	select book0_.BOOK_ID as BOOK_ID1_0_, 
//		   book0_.PAGE_COUNT as PAGE_COU2_0_, 
//		   book0_.PRICE as PRICE3_0_, 
//		   book0_.PUBLISH_DATE as PUBLISH_4_0_, 
//		   book0_.TITLE as TITLE5_0_ 
//		   from BOOK book0_ where book0_.TITLE=?
			
	public Book findByTitle(String title);
	
	// getBy, queryBy, countBy, readBy
	
	public List<Book> findByTitleLike(String title);
	
	public List<Book> findByTitleContaining(String title);
	
	public List<Book> findByTitleStartingWith(String title);
	
	public List<Book> findByTitleEndingWith(String title);
	
	public List<Book> findByTitleIgnoreCase(String title);
	
	// Relational Operations
	// Need to have implemented Comparable interface
	public List<Book> findByPageCountEquals(int pageCount);
	
	// public List<Book> findByPageCountGreaterThan(int pageCount);
	
	// public List<Book> findByPageCountLessThan(int pageCount);
	
	public List<Book> findByPageCountGreaterThanEqual(int pageCount);
	
	public List<Book> findByPageCountLessThanEqual(int pageCount);
	
	public List<Book> findByPageCountBetween(int min, int max);
	
	// Logical Operations
	public List<Book> findByTitleContainingOrTitleContaining(String title1, String title2);
	
	public List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);
	
	public List<Book> findByTitleNot(String title);
	
	// Compare date
	public List<Book> findByPublishDateAfter(Date date);
	
	public List<Book> findByPublishDateBefore(Date date); 
	
	public List<Book> findByPublishDateBetween(Date date1, Date date2);
	
	// Ordering result
	public List<Book> findByTitleContainingOrderByTitleAsc(String title);
	
	public List<Book> findByTitleContainingOrderByTitleDesc(String title);
	
	// Limit query result
	public List<Book> findTopByOrderByPageCountAsc();
	
	public List<Book> findFirstByOrderByPageCountAsc();
	
	public List<Book> findOneByOrderByPageCountAsc();
	
	public List<Book> findTopByOrderByPageCountDesc();
	
	public List<Book> findTop6ByOrderByPriceDesc();
	
	public List<Book> findTop5ByTitleContainingOrderByPriceAsc(String s);
	
	// Nested properties
	public List<Book> findByAuthor_FirstName(String firstName);
	
	public List<Book> findByAuthorCountry(String country);
	
	// JPQL
	@Query("select b from Book b")
	public List<Book> getAllBooks();
	
	@Query("select b from Book b where b.pageCount > ?1")
	public List<Book> getBooksThatPageCountLargerThan(int pageCount);
	
	@Query("select b from Book b where b.title = :title")
	public List<Book> getBooksThatTitleEqual(@Param("title") String title);
	
	// Named query
	// NamedQuery not really working. But it shows a concept.
	
	// Paging result
	public List<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);
	
	// Sort result
	public List<Book> findByPageCountGreaterThan(int pageCount, Sort sort);
	
	// Different return type
	// public Collection<Book> findByPageCountGreaterThan(int pageCount);
	
	// public Iterable<Book> findByPageCountGreaterThan(int pageCount);
	
	// public Page<Book> findByPageCountLessThan(int pageCount, Pageable pageable);
	
	public Slice<Book> findByPageCountLessThan(int pageCount, Pageable pageable);
}
