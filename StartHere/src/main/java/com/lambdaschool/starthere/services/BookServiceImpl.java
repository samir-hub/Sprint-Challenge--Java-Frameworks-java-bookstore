package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookrepos;

    @Override
    public ArrayList<Book> findAll()
    {
        ArrayList<Book> list = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ArrayList<Book> findAllPageable(Pageable pageable)
    {
        ArrayList<Book> list = new ArrayList<>();
        bookrepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book findBookById(long id) throws EntityNotFoundException
    {
        return bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Book save(Book book)
    {
        return null;
    }

    @Override
    public Book update(Book book, long id)
    {
        Book currentBook = bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (book.getTitle() != null)
        {
            currentBook.setTitle(book.getTitle());
        }

        if (book.getISBN() != null)
        {
            currentBook.setISBN(book.getISBN());
        }

        if (book.getCopy() != 100000)
        {
            currentBook.setCopy(book.getCopy());
        }

        return bookrepos.save(currentBook);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book id " + id + " not found!"));
        bookrepos.deleteById(id);
    }

}
