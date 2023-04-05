package com.api.tweteroojava.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<TweetsModel> getAll(Pageable pageable) {
        return tweetRepository.findAll(pageable);
    }
    public List<TweetsModel> getAllByUsername(String username) {
        return tweetRepository.findByUsername(username);
    }
}
