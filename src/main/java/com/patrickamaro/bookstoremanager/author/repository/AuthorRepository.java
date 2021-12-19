package com.patrickamaro.bookstoremanager.author.repository;

import com.patrickamaro.bookstoremanager.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
