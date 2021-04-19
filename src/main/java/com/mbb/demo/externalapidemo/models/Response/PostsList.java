package com.mbb.demo.externalapidemo.models.Response;

import com.mbb.demo.externalapidemo.models.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostsList {

    private List<Posts> postsList;
}
