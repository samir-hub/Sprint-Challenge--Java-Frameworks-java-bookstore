package com.lambdaschool.starthere.controllers;


import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.AuthorService;
import com.lambdaschool.starthere.services.BookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class AuthorController
{
    @Autowired
    private AuthorService authorService;

    @ApiOperation(value= "return all Authors", response= Author.class, responseContainer = "List")

    @ApiImplicitParams({
                               @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                                                 value = "Results page you want to retrieve (0..N)"),
                               @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                                                 value = "Number of records per page."),
                               @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                                                 value = "Sorting criteria in the format: property(,asc|desc). " +
                                                         "Default sort order is ascending. " +
                                                         "Multiple sort criteria are supported.")})
    //http://localhost:2019/authors/authors/paging/?page=1&size=10
    //http://localhost:2019/authors/authors/paging/?sort=city&sort=name
    @GetMapping(value = "authors/authors/paging", produces = {"application/json"})
    public ResponseEntity<?> listAllAuthorsByPage(@PageableDefault(page=0,
                                                                 size=3)
                                                        Pageable pageable)
    {
        ArrayList<Author> myAuthors = authorService.findAllPageable(pageable);
        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }


    @GetMapping(value = "authors/authors", produces = {"application/json"})
    public ResponseEntity<?> listAllAuthors()
    {
        ArrayList<Author> myAuthors = authorService.findAll();
        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }


}
