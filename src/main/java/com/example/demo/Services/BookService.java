package com.example.demo.Services;

import com.example.demo.entities.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service  //this is used to tell that object of this class has to be made using @Autowired
public class BookService {

    private static List<Book> list = new ArrayList<>();
    static{
        list.add(new Book(1,"Java","ABC"));
        list.add(new Book(2,"Python","BDE"));
    }
    public List<Book> getAllBooks(){
        return list;
    }
    public Book getBookById(int id){
        Book singlebook;
        singlebook = list.stream().filter(e->e.getId()==id).findFirst().get();
        return singlebook;
    }
   //Adding book
    public void addBook(Book book)
    {
        list.add(book);
    }

    //Deleting book method
    public void deleteBook(int id)
    {
        Book singleBook;
        //    Using stream that comes in java 8 to get matching ID
        list = list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());

    }

    //Updating the book
    //Map function of stream will return objects which can be updated
     public void updateBook(Book book,int id)
     {
         list=list.stream().map(b->{
             if(b.getId()==id){
                 b.setTitle(book.getTitle());
                 b.setAuthor(book.getAuthor());
             }
                 return b;
         }).collect(Collectors.toList());

     }
}
