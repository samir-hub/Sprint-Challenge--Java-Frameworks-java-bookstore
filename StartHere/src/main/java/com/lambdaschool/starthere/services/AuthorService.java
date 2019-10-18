package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface AuthorService
{
    ArrayList<Author> findAllPageable(Pageable pageable);

    ArrayList<Author> findAll();

    Author findAuthorById(long id);

    Author save (Author author);

//    Author update(Author author, long id);

    void delete(long id);
}
