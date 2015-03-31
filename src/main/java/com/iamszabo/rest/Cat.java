package com.iamszabo.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cat {

   @Id
   @GeneratedValue
   private long id;
   private String name;
   private boolean nice;

   public Cat() {
   }

   public Cat(String name, boolean nice) {
      this.name = name;
      this.nice = nice;
   }

   public long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public boolean isNice() {
      return nice;
   }
}
