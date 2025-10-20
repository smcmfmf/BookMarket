package kr.ac.kopo.smcmfmf.bookmarket.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 해당되는 카테고리를 찾을 수 없을 때 처리하기 위한 사용자 정의 예외 클래스
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CategoryException extends RuntimeException{
    private String errorMeaage;

    public CategoryException() {
        super();
        this.errorMeaage = "요청한 도서 분야를 찾을 수 없습니다.";
    }
}
