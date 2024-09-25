package com.pironeer.week3.board.controller;

import com.pironeer.week3.board.dto.request.BoardCreateRequest;
import com.pironeer.week3.board.dto.request.BoardUpdateRequest;
import com.pironeer.week3.board.dto.response.BoardResponse;
import com.pironeer.week3.board.service.BoardService;
import com.pironeer.week3.global.dto.response.SuccessResponse;
import com.pironeer.week3.global.dto.response.result.ListResult;
import com.pironeer.week3.global.dto.response.result.SingleResult;
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
    public SuccessResponse<SingleResult<Long>> create(
            @RequestAttribute("id") String userId,
            @Valid @RequestBody BoardCreateRequest request){
        SingleResult<Long> save = boardService.save(request);
        return SuccessResponse.ok(save);
    }

    @GetMapping("/{topicId}")
    @Operation(summary = "게시물 단건 조회")
    public  SuccessResponse<SingleResult<BoardResponse>> read(@PathVariable("topicId") Long id){
        SingleResult<BoardResponse> response = boardService.findById(id);
        return SuccessResponse.ok(response);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public SuccessResponse<ListResult<BoardResponse>> readAll(){
        ListResult<BoardResponse> responses = boardService.findAll();
        return SuccessResponse.ok(responses);
    }

    @PutMapping
    @Operation(summary = "게시물 수정")
    public SuccessResponse<SingleResult<BoardResponse>> update(@Valid @RequestBody BoardUpdateRequest request){
        SingleResult<BoardResponse> response = boardService.update(request);
        return SuccessResponse.ok(response);
    }

    @DeleteMapping("/{topicId}")
    @Operation(summary = "게시물 삭제")
    public SuccessResponse<SingleResult<Long>> remove(@PathVariable("topicId") Long id){
        SingleResult<Long> deleteId = boardService.deleteById(id);
        return SuccessResponse.ok(deleteId);
    }
}
