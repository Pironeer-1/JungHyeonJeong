package com.pironeer.week3.board.service;

import com.pironeer.week3.board.dto.request.BoardCreateRequest;
import com.pironeer.week3.board.dto.request.BoardUpdateRequest;
import com.pironeer.week3.board.dto.response.BoardResponse;
import com.pironeer.week3.board.entity.Board;
import com.pironeer.week3.board.mapper.BoardMapper;
import com.pironeer.week3.board.repository.BoardRepository;
import com.pironeer.week3.global.dto.response.result.ListResult;
import com.pironeer.week3.global.dto.response.result.SingleResult;
import com.pironeer.week3.global.exception.CustomException;
import com.pironeer.week3.global.exception.ErrorCode;
import com.pironeer.week3.global.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public SingleResult<Long> save(BoardCreateRequest request){
        Board savedBoard = boardRepository.save(BoardMapper.from(request));
        return ResponseService.getSingleResult(savedBoard.getId());
    }

    public SingleResult<BoardResponse> findById(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        BoardResponse boardResponse = BoardResponse.of(board);
        return ResponseService.getSingleResult(boardResponse);
    }

    public ListResult<BoardResponse> findAll(){
        List<Board> boards = boardRepository.findAll();
        List<BoardResponse> list = boards.stream().map(BoardResponse::of).toList();
        return ResponseService.getListResult(list);
    }

    public SingleResult<BoardResponse> update(BoardUpdateRequest request){
        Board board = boardRepository.findById(request.id())
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));

        Board updatedBoard = boardRepository.save(board.update(request));
        BoardResponse boardResponse = BoardResponse.of(updatedBoard);
        return ResponseService.getSingleResult(boardResponse);
    }

    public SingleResult<Long> deleteById(Long id){
        Long deletedId = boardRepository.deleteById(id);
        return ResponseService.getSingleResult(deletedId);
    }
}
