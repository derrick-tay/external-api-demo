package com.mbb.demo.externalapidemo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbb.demo.externalapidemo.models.Posts;
import com.mbb.demo.externalapidemo.models.Request.PostsRequest;
import com.mbb.demo.externalapidemo.models.Response.PostsList;
import com.mbb.demo.externalapidemo.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    @Autowired
    PostsService postsService;

    @RequestMapping(value = "/v1/inquiry/list", method = RequestMethod.GET)
    public PostsList postsListing() throws JsonProcessingException {
        return postsService.fullListing();
    }

    @RequestMapping(value = "/v1/inquiry/userlist/{userId}", method = RequestMethod.GET)
    public PostsList userPostsList(@PathVariable("userId") String userId) throws Exception {
        return postsService.userPostsListing(userId);
    }

    @RequestMapping(value = "/v1/search/posts", method = RequestMethod.POST)
    public Posts postsInquiry(@Valid @RequestBody final PostsRequest postsRequest) throws Exception {
        return postsService.searchPosts(postsRequest);
    }


}
