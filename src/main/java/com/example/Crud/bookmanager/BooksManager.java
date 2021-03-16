package com.example.Crud.bookmanager;

import com.example.Crud.bookdao.BooksRepo;
import com.example.Crud.bookdao.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BooksManager {

    private BooksRepo booksRepo;

    @Autowired
    public BooksManager(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    public Optional<Books> findById(Long id){
        return booksRepo.findById(id);
    }

    public Iterable<Books> findAll(){
        return booksRepo.findAll();
    }

    public Books save(Books books){
        return booksRepo.save(books);
    }

    public void deleteById(Long id){
        booksRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Books(1L, "Thinking in Java", "Bruce Eckel", LocalDate.of(1995, 1, 1)));
        save(new Books(2L, "The Hunger Games", "Suzanne Collins", LocalDate.of(2008, 9, 14)));
        save(new Books(3L, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", LocalDate.of(1997, 6, 26)));
    }
}
