package com.dogyun.book.config.auth.dto;

import java.io.Serializable;

import com.dogyun.book.domain.user.User;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
        
}
