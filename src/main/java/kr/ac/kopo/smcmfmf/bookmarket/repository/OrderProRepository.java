package kr.ac.kopo.smcmfmf.bookmarket.repository;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProRepository extends JpaRepository<Order, Long> {

}
