package kr.ac.kopo.smcmfmf.bookmarket.service;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Book;
import kr.ac.kopo.smcmfmf.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired // 객체 참조 자동 주입
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }

    public Book getBookById(String bookId) {
        Book bookInfo = bookRepository.getBookById(bookId);
        return bookInfo;
    }

    @Override
    public List<Book> getBookByCategory(String category) {
        List<Book> booksByCategory = bookRepository.getBookByCategory(category);
        return booksByCategory;
    }
}
