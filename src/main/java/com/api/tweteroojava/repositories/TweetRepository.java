package com.api.tweteroojava.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tweteroojava.models.TweetsModel;

public interface TweetRepository extends JpaRepository<TweetsModel,UUID>{
    List<TweetsModel> findByUsername(String username);
}
