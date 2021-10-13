package ridi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc	//Controller annotation이 붙어있는 class를  Controller 로 등록해준다.
@ComponentScan("ridi.controller") // scan할 패지키 지정
public class ServletAppContext implements WebMvcConfigurer{
	
			//ViewResolver
		public void configureViewResolvers(ViewResolverRegistry registry) {
			WebMvcConfigurer.super.configureViewResolvers(registry);
			registry.jsp("/WEB-INF/views/",".jsp");
		}
		
		//정적 파일 세팅
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			WebMvcConfigurer.super.addResourceHandlers(registry);
			registry.addResourceHandler("/**").addResourceLocations("/resources/");
			registry.addResourceHandler("/bookImage/**").addResourceLocations("file:///C:/bookImage/");
		
		}
		@Bean
		public StandardServletMultipartResolver  multipartResolver() {
			return new StandardServletMultipartResolver();
		}
}