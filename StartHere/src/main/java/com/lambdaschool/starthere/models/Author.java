package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value="Author", description = "The Author Entity")
@Entity
@Table(name = "author")
public class Author extends Auditable
{
    @ApiModelProperty(name = "authorid",
                      value = "primary key for Author",
                      required = true,
                      example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @ApiModelProperty(name = "lname",
                      value = "last name of Author",
                      example = "Johnson")
    private String lname;

    @ApiModelProperty(name = "fname",
                      value = "first name of Author",
                      example = "Buddy")
    private String fname;

        @ApiModelProperty(name = "books",
                          value = "books Author has authored",
                          required = true,
                          example = "Calling Texas Home")
        @ManyToMany(mappedBy = "authors")
        @JsonIgnoreProperties("authors")
        private List<Book> books = new ArrayList<>();

    public Author()
    {
    }

    public Author(String lname, String fname, List<Book> books)
    {
        this.lname = lname;
        this.fname = fname;
        this.books = books;
    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getFname()
    {
        return fname;
    }


    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }
}