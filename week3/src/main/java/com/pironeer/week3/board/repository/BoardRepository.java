package com.pironeer.week3.board.repository;

import com.pironeer.week3.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    void save(Board board);
    Optional<Board> findById(Long id);
    List<Board> findAll();
    void deleteById(Long id);
}
