package com.api.tweteroojava.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping("/api/tweets")
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
    public ResponseEntity<List<TweetsModel>> getAllTwewts(@PageableDefault(page = 0, size= 5) @Valid Pageable pageable) {
        List<TweetsModel> tweetsModels = new ArrayList<TweetsModel>();
        List<TweetsModel> tweetsReverse = new ArrayList<TweetsModel>();
        int size = 0;
        tweetsModels = tweetService.getAll(pageable).getContent();
        size = tweetsModels.size();

        for (int i = size - 1; i >= 0 ; i--) {
            tweetsReverse.add(tweetsModels.get(i));
        }
        return ResponseEntity.status(HttpStatus.OK).body(tweetsReverse);
    }
}
