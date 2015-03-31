package com.iamszabo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class ViewCatController extends WebMvcConfigurerAdapter{

   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/image").setViewName("image");
      registry.addViewController("/").setViewName("index");
      registry.addViewController("/login").setViewName("login");
   }
}
