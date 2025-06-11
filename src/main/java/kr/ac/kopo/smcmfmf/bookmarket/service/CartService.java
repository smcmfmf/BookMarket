package kr.ac.kopo.smcmfmf.bookmarket.service;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
}
