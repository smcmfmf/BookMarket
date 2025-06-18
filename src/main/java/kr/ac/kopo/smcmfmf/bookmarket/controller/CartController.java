package kr.ac.kopo.smcmfmf.bookmarket.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.ac.kopo.smcmfmf.bookmarket.domain.Book;
import kr.ac.kopo.smcmfmf.bookmarket.domain.Cart;
import kr.ac.kopo.smcmfmf.bookmarket.domain.CartItem;
import kr.ac.kopo.smcmfmf.bookmarket.exception.BookIdException;
import kr.ac.kopo.smcmfmf.bookmarket.service.BookService;
import kr.ac.kopo.smcmfmf.bookmarket.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;

    @GetMapping
    public String requestCartId(HttpServletRequest request) {
        System.out.println("Call requestCartId()"); // 콘솔창에 카트 아이디 출력
        String sessionId = request.getSession().getId();
        return "redirect:/cart/" + sessionId; // 이동할 페이지로 리다이렉트
    }

    @PostMapping
    public @ResponseBody Cart create(@RequestBody Cart cart) {
        System.out.println("Call create()"); // 콘솔창에 카트 출력
        return cartService.create(cart);
    }
    
    @GetMapping("/{cartId}")
    public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model) {
        System.out.println("Call requestCartList()"); // 콘솔창에 카트 목록 출력
        Cart cart = cartService.read(cartId);
        model.addAttribute("cart", cart); // 해당되는 카트의 목록을 모델에 추가하고, 뷰에 출력
        return "cart";
    }

    @PutMapping("{cartId}")
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        System.out.println("Call read()"); // 콘솔창에 카트 목록 출력
        return cartService.read(cartId);
    }
    
    @PutMapping("/book/{bookId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT) // 콘텐츠가 없을 때
    public void addCartByNewItem(@PathVariable("bookId") String bookId, HttpServletRequest request) {
        String sessionId = request.getSession().getId(); // 세션 ID가 있다면 반환
        Cart cart = cartService.read(sessionId);

        if(cart == null)
        {
            cart = cartService.create(new Cart(sessionId)); // 카트 생성
        }

        Book book = bookService.getBookById(bookId);
        if(book == null)
        {
            throw new IllegalArgumentException(new BookIdException(bookId)); // Book이 없을 때
        }

        cart.addCartItem(new CartItem(book));

        cartService.update(sessionId, cart);
    }

    @DeleteMapping("/book/{bookId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartByItem(@PathVariable("bookId") String bookId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);

        if(cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Book book = bookService.getBookById(bookId);
        if(book == null) {
            throw new IllegalArgumentException(new BookIdException(bookId));
        }

        cart.removeCartItem(new CartItem(book));

        cartService.update(sessionId, cart);
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCartList(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }
}
