package kr.ac.kopo.smcmfmf.bookmarket.domain;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
//@Getter
//@Setter
//@NoArgsConstructor // 공백 주의
public class Book {
    @Pattern(regexp = "isbn[0-9]+") // isbn 번호 체계
    private String bookId; // 도서번호
    @Size(min = 4, max = 50) // 최소, 최대 도서명 길이
    private String name; // 도서명
    @Min(value = 0) // 최소 0 이상의 수
    @Digits(integer = 8, fraction = 2) // 정수는 8자리, 소수는 2자리
    @NotNull // 입력 생략
    private BigDecimal unitPrice; // 단가
    private String author; // 저자
    private String description; // 도서 설명
    private String publisher; // 출판사
    private String category; // 도서 분류
    private long unitsInStock; // 재고량
    private String releaseDate; // 출판일
    private String condition; // 신규도서 or 중고도서 or 전자책
    private String fileName; // 도서 이미지 파일
    private MultipartFile bookImage; // 업로드된 도서 이미지 파일
}
