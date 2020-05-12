package com.graphql.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.bookstore.model.Author;
import com.graphql.bookstore.model.Book;
import com.graphql.bookstore.repository.AuthorRepository;
import com.graphql.bookstore.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null) {
            throw new IllegalArgumentException("The book to be updated was found");
        }
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}
