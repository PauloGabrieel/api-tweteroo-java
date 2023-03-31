package com.api.tweteroojava.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroojava.dtos.TweetDto;
import com.api.tweteroojava.models.TweetsModel;
import com.api.tweteroojava.services.TweetService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    final TweetService tweetService;
    
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<Object> saveTweet(@RequestBody @Valid TweetDto tweetDto) {
        TweetsModel tweetsModel = new TweetsModel();
        BeanUtils.copyProperties(tweetDto, tweetsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(tweetService.save(tweetsModel));
    }

    @GetMapping
    public ResponseEntity<List<TweetsModel>> getAllTwewts() {
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.getAll());
    }
}
