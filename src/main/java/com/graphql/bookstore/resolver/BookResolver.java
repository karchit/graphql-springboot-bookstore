package com.graphql.bookstore.resolver;


import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.bookstore.model.Author;
import com.graphql.bookstore.model.Book;
import com.graphql.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).get();
    }
}
