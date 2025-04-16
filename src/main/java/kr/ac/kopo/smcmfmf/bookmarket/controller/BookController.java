package kr.ac.kopo.smcmfmf.bookmarket.controller;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Book;
import kr.ac.kopo.smcmfmf.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("book")
    public String requestBookById(@RequestParam("id") String bookId, Model model) {
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book); /* 뷰 객체로 값을 보냄 */
        return "book";
    }

    @GetMapping("/{category}")
    public String requestBookByCategory(@PathVariable("category") String category, Model model) {
        List<Book> bookByCategory = bookService.getBookByCategory(category); /* 선택한 카테고리로 정렬된 리스트 */
        model.addAttribute("bookList", bookByCategory);
        return "books";
    }
}
