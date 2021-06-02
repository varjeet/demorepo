package com.example.demo.controller;

import com.example.demo.Services.BookService;
import com.example.demo.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//For Rest API's use @RestCOntroller instead of @controller
@RestController
public class BooksController {

    //Get ALL books
    @Autowired
    private BookService bookService;
    //@RequestMapping(value="/books",method = RequestMethod.GET)
    @GetMapping("/books")
    public List<Book> getBooks()
    {

        return this.bookService.getAllBooks();
    }
    @GetMapping("/books/{id}")
    public Book getSingleBook(@PathVariable("id") int id){
        return this.bookService.getBookById(id);
    }

      // Adding book

    @PostMapping("/books")
    public String addAllBooks(@RequestBody(required = false) Iterable<Book> book1,@RequestBody Book book2){ //what requestbody do: Whole data we are getting from frontend/postman for book will be in request body
        this.bookService.addAllBooks(book1);
        return "Inserted";
    }

       //Deleting book
    @DeleteMapping("/books/{id}")
    public void deletebook(@PathVariable("id") int id)
    {
        this.bookService.deleteBook(id);

    }
    //Updating book
    public Book updateBook(@RequestBody Book book, @RequestParam("id") int id)
    {
        this.bookService.updateBook(book,id);
        return book;
    }
}























