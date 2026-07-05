package com.library.LibraryManagement;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.repository.BookRepository;
import com.library.service.BookService;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookRepository repo = (BookRepository) app.getBean("bookRepository");
        BookService service = (BookService) app.getBean("bookService");

        repo.connection();
        service.log();
        app.close();
    }
}