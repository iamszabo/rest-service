package com.iamszabo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestCatController {

   @RequestMapping("/nice")
   public Cat nice(@RequestParam(value = "name") String name) {
      return new Cat(name, name.length() % 2 == 0);
   }

   @RequestMapping("/static")
   public Cat staticCat() {
      return new Cat("kitty", true);
   }

   @RequestMapping("/supercat")
   public Cat receiveStaticCat() {
      Cat cat = new RestTemplate().getForObject("http://localhost:8080/static", Cat.class);
      return new Cat(cat.getName() + " super cat", cat.isNice());
   }
}
