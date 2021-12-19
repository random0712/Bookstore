package com.patrickamaro.bookstoremanager.publishers.repository;

import com.patrickamaro.bookstoremanager.publishers.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
