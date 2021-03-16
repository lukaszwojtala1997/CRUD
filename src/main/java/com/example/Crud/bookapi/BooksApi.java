package com.example.Crud.bookapi;

import com.example.Crud.bookdao.entity.Books;
import com.example.Crud.bookmanager.BooksManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
class BooksApi {

    private BooksManager booksManager;

    @Autowired
    public BooksApi(BooksManager booksManager) {
        this.booksManager = booksManager;
    }

    @GetMapping("/allbooks")
    public Iterable<Books> getAll(){
        return booksManager.findAll();
    }

    @GetMapping
    public Optional<Books> getById(@RequestParam Long index){
        return booksManager.findById(index);
    }

    @PostMapping
    public Books addVideo(@RequestBody Books books){
        return booksManager.save(books);
    }

    @PutMapping
    public Books updateVideo(@RequestBody Books books){
        return booksManager.save(books);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        booksManager.deleteById(index);


    }


}
