package kr.ac.kopo.smcmfmf.bookmarket.repository;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookRepository {
    List<Book> getAllBookList(); // 도메인 Book과 연결함
    Book getBookById(String bookId); // Book 객체를 반환함'
    List<Book> getBookByCategory(String category);
    // Array는 중복값을 허용, Set은 중복값을 허용하지 않는다.
    Set<Book> getBookListByFilter(Map<String, List<String>> filter);

}
