package me.alwaysawake.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postservice;

    //등록
    @PostMapping("/posts")
    public ResponseEntity<Void> savePosts(@RequestBody PostsSaveRequestDto dto) {
        postservice.save(dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


//    @PostMapping("/posts/{id}")
//    public ResponseEntity<Void> savePosts(@PathVariable(value = "id") int i) {
//        postservice.save(dto.toEntity());
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//
//    @PostMapping("/posts")
//    public ResponseEntity<Void> savePosts(@ModelAttribute PostsSaveRequestDto dto) {
//        postservice.save(dto.toEntity());
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

    //수정
    @PutMapping("/posts/{post-id}")
    public ResponseEntity<Void> putPosts(@RequestBody PostsSaveRequestDto dto, @PathVariable(value = "post-id") Long postId) {
        postservice.put(dto, postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //삭제
    @DeleteMapping("/posts/{post-id}")
    public ResponseEntity<Void> deletePosts(@PathVariable(value = "post-id") Long postId) {
        postservice.delete(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //조회
    @GetMapping("/posts/{post-id}")
    public ResponseEntity<PostsGetDetailResponseDto> getDetailPosts(@PathVariable(value = "post-id") Long postId) {
        return ResponseEntity.status(HttpStatus.OK).body(postservice.getDetail(postId));
    }

    //리스트 조회
    @GetMapping("/posts")
    public ResponseEntity<List<PostsGetDetailResponseDto>> getListPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postservice.getList());
    }
}
