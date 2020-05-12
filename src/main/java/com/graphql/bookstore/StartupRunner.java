package com.graphql.bookstore;

import com.graphql.bookstore.model.Author;
import com.graphql.bookstore.model.Book;
import com.graphql.bookstore.repository.AuthorRepository;
import com.graphql.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {
    BookRepository bookRepository;
    AuthorRepository authorRepository;
    
    public StartupRunner(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Running Spring Application!");

        Author author = new Author("Herbert", "Schildt");
        authorRepository.save(author);

        bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
    }
}
