package com.example.Crud.bookdao;

import com.example.Crud.bookdao.entity.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends CrudRepository<Books, Long> {
}
