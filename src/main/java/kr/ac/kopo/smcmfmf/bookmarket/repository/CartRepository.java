package kr.ac.kopo.smcmfmf.bookmarket.repository;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Cart;
import org.springframework.stereotype.Repository;

public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart); // 카트의 아이디와 카트 객체를 전달함
    void delete(String cartId);//카트안에 전체 항목들을 삭제
}
