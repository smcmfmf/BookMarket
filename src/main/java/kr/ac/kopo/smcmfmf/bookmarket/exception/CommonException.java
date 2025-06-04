package kr.ac.kopo.smcmfmf.bookmarket.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {
    @ExceptionHandler(value = RuntimeException.class)
    private ModelAndView handleException(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("Exception", e.toString()); // Http 에러 코드 출력
        mav.setViewName("errorCommon");
        return mav;
    }
}
