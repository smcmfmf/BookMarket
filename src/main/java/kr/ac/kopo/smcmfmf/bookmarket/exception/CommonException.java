package kr.ac.kopo.smcmfmf.bookmarket.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {
    @ExceptionHandler(value = CategoryException.class)
    private ModelAndView handleException(HttpServletRequest request, CategoryException e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("InvalidCategory", e.getCategory());
        mav.addObject("Exception", e.toString()); // Http 에러 코드 출력
        mav.addObject("Url", request.getRequestURL()); // 오류가 발생한 URL을 출력함
        mav.addObject("Message", e.getErrorMessage());
        mav.setViewName("errorCommon");
        return mav;
    }
}
