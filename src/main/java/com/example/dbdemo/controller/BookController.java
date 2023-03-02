package com.example.dbdemo.controller;

import com.example.dbdemo.DbdemoApplication;
import com.example.dbdemo.dto.BookRequestDTO;
import com.example.dbdemo.dto.BookResponseDTO;
import com.example.dbdemo.model.Book;
import com.example.dbdemo.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    private static final Log LOGGER = LogFactory.getLog(BookController.class);
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<List<BookResponseDTO>> getBooks(){
           List<BookResponseDTO> bookList = bookService.getAllBooks();
           if(bookList.size()>0){
               return new ResponseEntity<List<BookResponseDTO>>(bookList, HttpStatus.OK);
           }else{
               LOGGER.info("There is no books available");
               return new ResponseEntity<List<BookResponseDTO>>(bookList, HttpStatus.NO_CONTENT);
           }

    }
    @PostMapping("/books")
    public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody BookRequestDTO bookRequestDTO){
      BookResponseDTO bookResponseDTO =  bookService.addBook(bookRequestDTO);
      if(bookResponseDTO!=null){
          return new ResponseEntity<BookResponseDTO>(bookResponseDTO,HttpStatus.CREATED);
      }
      return null;
    }
    @GetMapping("/books/{bookId}")
    public BookResponseDTO getBookById(@PathVariable int bookId){
        return bookService.getBook(bookId);
    }
    @PutMapping("/books/{bookId}")
    public BookResponseDTO updateBookById(@PathVariable int bookId,@RequestBody  BookRequestDTO bookRequestDTO){
        return bookService.updateBook(bookId,bookRequestDTO);
    }
    @DeleteMapping("/books/{bookId}")
    public BookResponseDTO deleteBookById(@PathVariable int bookId){
        return bookService.deleteBookById(bookId);
    }
}
