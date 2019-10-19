package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public ArrayList<Author> findAllPageable(Pageable pageable)
    {
        ArrayList<Author> list = new ArrayList<>();
        authorrepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ArrayList<Author> findAll()
    {
        ArrayList<Author> list = new ArrayList<>();
        authorrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Author findAuthorById(long id)
    {
        return null;
    }

    @Override
    public Author save(Author author)
    {
        return null;
    }

//    @Override
//    public Author update(Author author, long id)
//    {
//        Author currentAuthor = authorrepos.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
//
//        if (author.getTitle() != null)
//        {
//            currentBook.setTitle(book.getTitle());
//        }
//
//
//        return bookrepos.save(currentBook);
//    }

    @Override
    public void delete(long id)
    {

    }
}
