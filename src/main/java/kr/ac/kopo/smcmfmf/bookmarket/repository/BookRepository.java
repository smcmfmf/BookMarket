package kr.ac.kopo.smcmfmf.bookmarket.repository;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList(); // 도메인 Book과 연결함
}
