package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value="Book", description = "The Book Entity")
@Entity
@Table(name = "book")
public class Book extends Auditable
{
    @ApiModelProperty(name = "bookid",
                      value = "primary key for Book",
                      required = true,
                      example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @ApiModelProperty(name = "title",
                      value = "title of Book",
                      example = "Calling Texas Home")
    private String title;

    @ApiModelProperty(name = "ISBN",
                      value = "ISBN of Book",
                      example = "9780738206752")
    private String ISBN;

    @ApiModelProperty(name = "copy",
                      value = "copyright year of Book",
                      example = "2001")
    private int copy;

    @ApiModelProperty(name = "section", value = "section that book is in", required = true, example = "Fiction")
    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
    private Section section;


    @ApiModelProperty(name = "authors", value = "authors that wrote the Book", example = "Buddy Johnson")
    @ManyToMany
    @JoinTable(name = "bookauthors",
               joinColumns = {@JoinColumn(name = "bookid")},
               inverseJoinColumns = {@JoinColumn(name = "authorid")})
    @JsonIgnoreProperties("books")
    private List<Author> authors = new ArrayList<>();

    public Book()
    {
    }

    public Book(String title, String ISBN, int copy, Section section, List<Author> authors)
    {
        this.title = title;
        this.ISBN = ISBN;
        this.copy = copy;
        this.section = section;
        this.authors = authors;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }

    public Section getSection()
    {
        return section;
    }

    public void setSection(Section section)
    {
        this.section = section;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }
}