package kr.ac.kopo.smcmfmf.bookmarket.repository;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList(); // 도메인 Book과 연결함
    Book getBookById(String bookId); // Book 객체를 반환함'
    List<Book> getBookByCategory(String category);
}
