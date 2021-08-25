package com.dogyun.book.controller;

import javax.servlet.http.HttpSession;

import com.dogyun.book.config.auth.LoginUser;
import com.dogyun.book.config.auth.dto.SessionUser;
import com.dogyun.book.controller.dto.PostsResponseDto;
import com.dogyun.book.domain.user.User;
import com.dogyun.book.service.posts.PostsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping(value = "/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping(value = "/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping(value = "/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
