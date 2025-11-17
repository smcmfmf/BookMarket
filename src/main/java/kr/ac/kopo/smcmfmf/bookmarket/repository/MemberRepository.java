package kr.ac.kopo.smcmfmf.bookmarket.repository;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByMemberId(String memberId);
}
