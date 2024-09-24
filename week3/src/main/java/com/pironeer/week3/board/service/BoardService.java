package com.pironeer.week3.board.service;

import com.pironeer.week3.board.dto.request.BoardCreateRequest;
import com.pironeer.week3.board.dto.request.BoardUpdateRequest;
import com.pironeer.week3.board.dto.response.BoardResponse;
import com.pironeer.week3.board.entity.Board;
import com.pironeer.week3.board.mapper.BoardMapper;
import com.pironeer.week3.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardCreateRequest request){
        boardRepository.save(BoardMapper.from(request));
    }

    public BoardResponse findById(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        return BoardResponse.of(board);
    }

    public List<BoardResponse> findAll(){
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardResponse::of).toList();
    }

    public BoardResponse update(BoardUpdateRequest request){
        Board board = boardRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        boardRepository.save(board.update(request));
        return BoardResponse.of(board);
    }

    public void deleteById(Long id){
        boardRepository.deleteById(id);
    }
}
