package com.iamszabo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RestCatController {

   @Autowired
   private CatRepository catRepository;

   @RequestMapping("/add")
   public Cat add(@RequestParam String name) {
      Cat cat = new Cat(name, catMagic(name));
      catRepository.save(cat);
      return cat;
   }
   @RequestMapping("/find")
   public List<Cat> find(@RequestParam String name) {
      return catRepository.findByName(name);
   }

   @RequestMapping("/nice")
   public Cat nice(@RequestParam(value = "name") String name) {
      return new Cat(name, catMagic(name));
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

   private boolean catMagic(String name) {
      return name.length() % 2 == 0;
   }
}
