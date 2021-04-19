package com.mbb.demo.externalapidemo.models.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PostsRequest {

    @NotNull(message = "Please fill your User ID")
    private Integer userId;

    @NotNull(message = "Please fill your Posts ID")
    private Integer id;
}
