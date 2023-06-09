package com.api.tweteroojava.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {
    
    @NotBlank
    private String username;
    
    @NotBlank
    private String avatar;

    
}
