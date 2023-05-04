package com.majorProject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String author;

    @Lob
    private byte[] data;

    public Book(String name, String author, byte[] data) {
        this.name = name;
        this.author = author;
        this.data = data;
    }
}
