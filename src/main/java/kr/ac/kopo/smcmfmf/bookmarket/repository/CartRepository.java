package kr.ac.kopo.smcmfmf.bookmarket.repository;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Cart;
import org.springframework.stereotype.Repository;

public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
}
