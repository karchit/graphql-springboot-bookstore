package com.graphql.bookstore.repository;

import com.graphql.bookstore.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
