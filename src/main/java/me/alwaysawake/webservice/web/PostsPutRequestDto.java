package me.alwaysawake.webservice.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsPutRequestDto {

    private String title;
    private String content;

}
