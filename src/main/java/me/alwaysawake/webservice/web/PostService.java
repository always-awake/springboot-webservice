package me.alwaysawake.webservice.web;

import java.util.List;

public interface PostService {
    void save(PostsSaveRequestDto postsSaveRequestDto);

    void delete(Long postId);

    PostsGetDetailResponseDto getDetail(Long postId);

    List<PostsGetDetailResponseDto> getList();

    PostsPutResponseDto put(PostsSaveRequestDto postsSaveRequestDto, Long postId);
}
