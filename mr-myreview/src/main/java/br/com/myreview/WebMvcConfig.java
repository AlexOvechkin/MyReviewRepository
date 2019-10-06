package br.com.myreview;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.myreview.controller.HomeController;


@SuppressWarnings("deprecation")
@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class })
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{

	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
