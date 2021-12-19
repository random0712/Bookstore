package com.patrickamaro.bookstoremanager.books.repository;

import com.patrickamaro.bookstoremanager.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
