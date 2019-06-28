package me.alwaysawake.webservice.web;

import lombok.AllArgsConstructor;
import me.alwaysawake.webservice.domain.posts.Posts;

@AllArgsConstructor
public class PostsPutResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    private PostsPutResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
    }

    public static PostsPutResponseDto toDto(Posts posts) {
        return new PostsPutResponseDto(posts);
    }

}

