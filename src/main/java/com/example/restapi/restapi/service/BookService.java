package com.example.restapi.restapi.service;

import com.example.restapi.restapi.entity.Book;
import com.example.restapi.restapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    /*private BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }*/

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return this.bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return this.bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        if (!this.bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }

        this.bookRepository.deleteById(id);
    }
}
