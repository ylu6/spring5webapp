package ylu.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ylu.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository; // auto wire the bookRepository by Spring
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll()); // add a attribute "books" to the model, which is all the book instances
        return "books"; // return string "books" as a view name for thymeleaf
    }
}
