package kr.ac.kopo.smcmfmf.bookmarket.repository;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository {
    private Map<String, Cart> listOfCarts;

    public CartRepositoryImpl() {
        listOfCarts = new HashMap<String, Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        // 만약 cartId가 이미 존재한다면
        if(listOfCarts.containsKey(cart.getCartId())) {
            throw new IllegalArgumentException("해당 장바구니의 ID(" + cart.getCartId() + ")가 이미 존재하여 새로 생성할 수 없습니다.");
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if(!listOfCarts.containsKey(cartId)) {
            throw new IllegalArgumentException("장바구니가 존재하지 않아 목록을 업데이트할 수 없습니다.");
        }
        listOfCarts.put(cartId, cart); // 해당되는 카드에 목록을 추가
    }

    @Override
    public void delete(String cartId) {
        if(!listOfCarts.containsKey(cartId)){
            throw new IllegalArgumentException("장바구니가 존재하지 않아 목록을 업데이트할 수 없습니다.");
        }
        listOfCarts.remove(cartId);
    }
}
