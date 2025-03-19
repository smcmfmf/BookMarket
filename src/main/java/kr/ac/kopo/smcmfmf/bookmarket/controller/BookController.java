package kr.ac.kopo.smcmfmf.bookmarket.controller;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Book;
import kr.ac.kopo.smcmfmf.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET) // 출력할 페이지
    public String requestBookList(Model model) { // HTML에서 사용할 수 있도록
        List<Book> bookList = bookService.getAllBookList();
        model.addAttribute("bookList", bookList); // 도서 리스트를 사용함
        return "books";
    }
}
