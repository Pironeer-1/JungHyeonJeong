package com.pironeer.week3.board.controller;

import com.pironeer.week3.board.dto.request.BoardCreateRequest;
import com.pironeer.week3.board.dto.request.BoardUpdateRequest;
import com.pironeer.week3.board.dto.response.BoardResponse;
import com.pironeer.week3.board.service.BoardService;
import com.pironeer.week3.global.dto.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "게시물(Board)")
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    @Operation(summary = "게시물 작성")
    public SuccessResponse<Long> create(@Valid @RequestBody BoardCreateRequest request){
        Long saveId = boardService.save(request);
        return SuccessResponse.ok(saveId);
    }

    @GetMapping("/{topicId}")
    @Operation(summary = "게시물 단건 조회")
    public  SuccessResponse<BoardResponse> read(@PathVariable("topicId") Long id){
        BoardResponse response = boardService.findById(id);
        return SuccessResponse.ok(response);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public SuccessResponse<List<BoardResponse>> readAll(){
        List<BoardResponse> responses = boardService.findAll();
        return SuccessResponse.ok(responses);
    }

    @PutMapping
    @Operation(summary = "게시물 수정")
    public ResponseEntity<BoardResponse> update(@Valid @RequestBody BoardUpdateRequest request){
        BoardResponse response = boardService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{topicId}")
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<Long> remove(@PathVariable("topicId") Long id){
        Long deleteId = boardService.deleteById(id);
        return ResponseEntity.ok().body(deleteId);
    }
}
