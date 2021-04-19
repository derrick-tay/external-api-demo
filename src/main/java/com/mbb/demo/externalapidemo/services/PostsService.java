package com.mbb.demo.externalapidemo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbb.demo.externalapidemo.models.Posts;
import com.mbb.demo.externalapidemo.models.Request.PostsRequest;
import com.mbb.demo.externalapidemo.models.Response.PostsList;
import com.mbb.demo.externalapidemo.util.ApiConstant;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    HttpHeaders httpHeaders;

    @Autowired
    RestTemplate restTemplate;

    public PostsList fullListing() throws JsonProcessingException {

        PostsList postsList = new PostsList();
        postsList.setPostsList(retrievePostingList());

        return postsList;
    }

    public PostsList userPostsListing(String userId) throws Exception {
        PostsList postsList = new PostsList();

        List<Posts> userPostList;
        try {
            userPostList = retrievePostingList().stream()
                    .filter(x -> x.getUserId().equals(Integer.parseInt(userId)))
                    .collect(Collectors.toList());
        } catch (NumberFormatException nEx) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input correct userId", nEx);
        }

        postsList.setPostsList(userPostList);

        if (!ObjectUtils.isEmpty(userPostList)) {
            return postsList;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Posts Not Found!!!");
        }
    }

    public Posts searchPosts(PostsRequest postsRequest) throws JsonProcessingException {

        List<Posts> userPostList = retrievePostingList().stream()
                .filter(x -> x.getUserId().equals(postsRequest.getUserId()) && x.getId().equals(postsRequest.getId()))
                .collect(Collectors.toList());

        if (!ObjectUtils.isEmpty(userPostList) && !ObjectUtils.isEmpty(userPostList.get(0))) {
            return userPostList.get(0);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Search Posts Not Found!!!");
        }
    }

    private List<Posts> retrievePostingList() throws JsonProcessingException {

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        String response = restTemplate.exchange(ApiConstant.POSTING_URL, HttpMethod.GET, entity, String.class).getBody();

        return objectMapper.readValue(response, new TypeReference<List<Posts>>() {
        });
    }
}
