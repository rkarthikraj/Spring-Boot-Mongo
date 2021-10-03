package com.practise.application.resource;

import com.practise.application.model.Book;
import com.practise.application.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return "Added book with id :" + book.getBookId();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/findBookById/{id}")
    public Optional<Book> getBook(@PathVariable int id) {
        return bookRepository.findById(id);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public String deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
        return "Book deleted with id :" + id;
    }
}
