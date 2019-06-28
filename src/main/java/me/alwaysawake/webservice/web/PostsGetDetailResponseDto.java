package me.alwaysawake.webservice.web;

import lombok.AllArgsConstructor;
import me.alwaysawake.webservice.domain.posts.Posts;

@AllArgsConstructor
public class PostsGetDetailResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    private PostsGetDetailResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
    }

    public static PostsGetDetailResponseDto toDto(Posts posts) {
        return new PostsGetDetailResponseDto(posts);
    }

}
