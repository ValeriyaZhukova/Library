package kz.iitu.library;

import kz.iitu.library.model.BookCategory;
import kz.iitu.library.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Library library = context.getBean("library", Library.class);

        library.run();

    }
}
