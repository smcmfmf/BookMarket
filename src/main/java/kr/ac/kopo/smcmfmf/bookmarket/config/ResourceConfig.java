package kr.ac.kopo.smcmfmf.bookmarket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
    @Value("@{file.uploadDir}") // application.properties에 선언한 파일 저장 위치를 사용
    String fileDir; // 파일 경로 저장
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/BookMarket/images/**") // URI (상대 경로)
                .addResourceLocations("file:///" + fileDir) // 윈도우 파일 경로
                .setCachePeriod(60 * 60 * 24 * 365); // 접근하는 파일 캐싱 시간
    }
}
