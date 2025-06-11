package kr.ac.kopo.smcmfmf.bookmarket.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.ac.kopo.smcmfmf.bookmarket.domain.Cart;
import kr.ac.kopo.smcmfmf.bookmarket.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

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
}
