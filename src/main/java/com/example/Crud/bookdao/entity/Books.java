package com.example.Crud.bookdao.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Books {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String author;
    private LocalDate productionYear;

    public Books() {

    }

    public Books(Long id, String title, String author, LocalDate productionYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.productionYear = productionYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
