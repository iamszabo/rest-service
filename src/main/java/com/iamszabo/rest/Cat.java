package com.iamszabo.rest;

public class Cat {

   private String name;
   private boolean nice;

   public Cat() {
   }

   public Cat(String name, boolean nice) {
      this.name = name;
      this.nice = nice;
   }

   public String getName() {
      return name;
   }

   public boolean isNice() {
      return nice;
   }
}
