package com.api.tweteroojava.services;

import org.springframework.stereotype.Service;

import com.api.tweteroojava.models.TweetsModel;
import com.api.tweteroojava.repositories.TweetRepository;

@Service
public class TweetService {
    
    final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }

    public TweetsModel save(TweetsModel tweetsModel) {
        return tweetRepository.save(tweetsModel);
    }
}