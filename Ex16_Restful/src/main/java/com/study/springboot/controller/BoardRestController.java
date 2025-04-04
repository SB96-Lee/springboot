package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@RestController
@RequestMapping("/rest")
public class BoardRestController {
	
	@Autowired
	BoardRepository boardRepository;
	
	@GetMapping("/boardall")
	public List<Board> getBoardAll() {
		return boardRepository.findAll();
	}
	
	
	@GetMapping("/board")
	public Board getBoardTitleAndContent(@RequestParam("title") String title, 
											@RequestParam("content") String content) {
		return boardRepository.findByTitleAndContent(title, content);
	}
	
	@GetMapping("/board/{bno}")
	public Board getBoardTitleAndContent(@PathVariable(name="bno") Long bno) {
		return boardRepository.findById(bno).get();
	}
	
	//http://localhost:8080/swagger-ui/index.html 에서만 삭제 가능
	@DeleteMapping("/dboard/{bno}")
	public ResponseEntity<?> deleteMenu(@PathVariable(name="bno") Long bno) {
			boardRepository.deleteById(bno);
			return ResponseEntity.noContent().build();
		}
	
	
}
