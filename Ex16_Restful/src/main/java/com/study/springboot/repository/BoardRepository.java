package com.study.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{

	Board findByTitleAndContent(String title, String content);

}
