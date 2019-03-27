package com.spring.rest.springrest.controllers;

import com.spring.rest.springrest.entities.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PostController {

    @GetMapping("/post")
    public Post getPost(){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<Post> response = restTemplate.getForEntity(url,Post.class);
//        System.out.println(response.getStatusCode().toString());
//        System.out.println(response.getHeaders().toString());
        return response.getBody();
    }

    @GetMapping("/postList")
    public List<Post> getPostList(){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<List<Post>> response = restTemplate
                .exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Post>>(){});
        return response.getBody();
    }
}
