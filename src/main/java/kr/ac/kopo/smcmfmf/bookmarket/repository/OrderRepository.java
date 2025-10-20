package kr.ac.kopo.smcmfmf.bookmarket.repository;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Order;

public interface OrderRepository {
    // 주문목록 저장
    Long saveOrder(Order order);
}