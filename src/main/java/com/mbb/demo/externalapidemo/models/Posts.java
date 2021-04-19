package com.mbb.demo.externalapidemo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Posts {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
