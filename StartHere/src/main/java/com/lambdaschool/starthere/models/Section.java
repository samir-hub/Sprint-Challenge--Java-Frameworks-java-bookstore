package com.lambdaschool.starthere.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value="Section", description = "The Section Entity")
@Entity
@Table(name = "section")
public class Section extends Auditable
{
    @ApiModelProperty(name = "sectionid",
                      value = "primary key for Section",
                      required = true,
                      example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @ApiModelProperty(name = "name",
                      value = "name for Section",
                      example = "Fiction")
    private String name;

    @ApiModelProperty(name = "books", value = "books in section", example = "Calling Texas Home")
    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties("sections")
    private List<Book> books = new ArrayList<>();

    public Section()
    {
    }

    public Section(String sectionname, List<Book> books)
    {
        this.name = name;
        this.books = books;
    }

    public long getSectionid()
    {
        return sectionid;
    }

    public void setSectionid(long sectionid)
    {
        this.sectionid = sectionid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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