package kr.ac.kopo.smcmfmf.bookmarket.controller;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Book;
import kr.ac.kopo.smcmfmf.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping // 출력할 페이지 설정
    public String requestBookList(Model model) { // HTML에서 사용할 수 있도록 참조값을 반환
        List<Book> bookList = bookService.getAllBookList();
        model.addAttribute("bookList", bookList); // 도서 리스트를 사용함
        return "books";
    }

    @GetMapping(value = "/all") // 출력할 페이지 설정
    public ModelAndView requestAllBookList() { // HTML에서 사용할 수 있도록 참조값을 반환
        ModelAndView modelV = new ModelAndView();
        modelV.setViewName("books");
        List<Book> bookList = bookService.getAllBookList();
        modelV.addObject("bookList", bookList); // 도서 리스트를 사용함
        return modelV;
    }
}
