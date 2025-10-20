package kr.ac.kopo.smcmfmf.bookmarket.service;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Order;

public interface OrderService {
    void confirmOrder(String bookId, long quantity); //도서 재고 수량 확인
    Long saveOrder(Order order);
}
