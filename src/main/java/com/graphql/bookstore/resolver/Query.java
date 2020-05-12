package com.graphql.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.bookstore.model.Author;
import com.graphql.bookstore.model.Book;
import com.graphql.bookstore.repository.AuthorRepository;
import com.graphql.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public Query(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Iterable<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public long countBooks(){
        return bookRepository.count();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
