package com.bit.springBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDTO {

   private int id;
   private String name;
   private String title;
   private String content;
   private String regdate;
   private int hit;
   
}