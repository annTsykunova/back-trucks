package by.baranavichy.backtrucks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Vanya on 02.05.2019.
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedMethods("GET", "PUT", "POST", "DELETE")
//                .allowedOrigins("http://localhost:4200");
//    }

}