package kr.ac.kopo.smcmfmf.bookmarket.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.ac.kopo.smcmfmf.bookmarket.domain.Book;
import kr.ac.kopo.smcmfmf.bookmarket.repository.BookRepository;
import kr.ac.kopo.smcmfmf.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookIdValidator implements ConstraintValidator<BookId, String>{

    @Autowired
    private BookService bookService;

    @Override
    public void initialize(BookId constraintAnnotation) {
        // TODO Auto-generated method stub
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Book book;
        try {
            book = bookService.getBookById(value);
        } catch (RuntimeException e) {
            return true;
        }
        if(book!= null) {
            return false;
        }
        return true;
    }
}
