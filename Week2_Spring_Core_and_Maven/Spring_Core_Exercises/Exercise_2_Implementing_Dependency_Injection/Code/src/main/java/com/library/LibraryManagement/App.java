package com.library.LibraryManagement;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class App {
    public static void main(String[] args) {
        // Container block start
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = (BookService) context.getBean("service");

        //Test the Injection
        service.run();

        // Context close
        context.close();
    }
}