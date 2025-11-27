package com.ayush.School.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        ViewControllerRegistration viewControllerRegistration=  registry.addViewController("/courses");
        viewControllerRegistration.setViewName("courses");
        registry.addViewController("/about").setViewName("about");
        //registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/thankyou").setViewName("thankyou");

    }


}
