package com.waa.labone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//try it with public record Post (long id,String title,String content,String author);
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;

    //many additional attribute.....
}
