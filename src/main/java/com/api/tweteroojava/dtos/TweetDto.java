package com.api.tweteroojava.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TweetDto {
    
    @NotBlank
    public String userName;
    
    @NotBlank
    public String avatar;

    @NotBlank
    public String tweet;
}
