package com.pironeer.week3.board.mapper;

import com.pironeer.week3.board.dto.request.BoardCreateRequest;
import com.pironeer.week3.board.entity.Board;

import java.time.LocalDateTime;

public class BoardMapper {
    public static Board from(BoardCreateRequest request){
        LocalDateTime now = LocalDateTime.now();
        return Board.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
