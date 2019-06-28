package me.alwaysawake.webservice.web;

import lombok.RequiredArgsConstructor;
import me.alwaysawake.webservice.domain.posts.Posts;
import me.alwaysawake.webservice.domain.posts.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostsRepository postsRepository;

    @Override
    public void save(PostsSaveRequestDto postsSaveRequestDto) {
        Posts posts = Posts.builder()
                .title(postsSaveRequestDto.getTitle())
                .content(postsSaveRequestDto.getContent())
                .author(postsSaveRequestDto.getAuthor())
                .build();
        postsRepository.save(posts);
    }

    @Override
    public void delete(Long postId) {
        postsRepository.deleteById(postId);
    }

    @Override
    public PostsGetDetailResponseDto getDetail(Long postId) {
        Posts posts = postsRepository.findById(postId).orElseThrow(NullPointerException::new);
        return new PostsGetDetailResponseDto(posts.getId(), posts.getTitle(), posts.getContent(), posts.getAuthor());
    }

    @Override
    public List<PostsGetDetailResponseDto> getList() {
        List<PostsGetDetailResponseDto> postsGetDetailResponseDtos = new ArrayList<>();
        List<Posts> posts = postsRepository.findAll();
        for (Posts post : posts) {
            postsGetDetailResponseDtos.add(
                    new PostsGetDetailResponseDto(
                            post.getId(),
                            post.getTitle(),
                            post.getContent(),
                            post.getAuthor())
            );
        }

//        postsGetDetailResponseDtos = posts
//                .stream().map(PostsGetDetailResponseDto::toDto)
//                .collect(Collectors.toList());
        return postsGetDetailResponseDtos;
    }

    @Override
    public PostsPutResponseDto put(PostsPutRequestDto postsPutRequestDto, Long postId) {
        Posts posts = postsRepository.findById(postId).orElseThrow(NullPointerException::new);
        posts.putTitle(postsPutRequestDto.getTitle());
        posts.putContent(postsPutRequestDto.getContent());
        postsRepository.save(posts);
        return new PostsPutResponseDto(
                posts.getId(),
                posts.getTitle(),
                posts.getContent(),
                posts.getAuthor()
        );
    }
}
