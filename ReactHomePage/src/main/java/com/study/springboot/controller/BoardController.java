package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Reply;
import com.study.springboot.service.BoardService;
import com.study.springboot.service.ReplyService;

@Controller
@SessionAttributes("loginUser")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	ReplyService replyService;
	
	@GetMapping("/list")
	public String list(@RequestParam(value="nowPage", defaultValue="0") int nowPage, Model model) {
		Page<Board> pageList = boardService.list(PageRequest.of(nowPage, 10, Sort.by(Sort.Direction.DESC, "bno")));
		
		model.addAttribute("boardPage", pageList);
		model.addAttribute("board", pageList.getContent());
		return "board/list";
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		return "board/insertForm";
	}
	
	@PostMapping("/insert")
	public String insert(Board board, Model model) {
		boardService.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("/detailForm")
	public String detailForm(@RequestParam("bno") Long bno, Model model) {
		// .get()으로 Optional을 풀어줘야 사용 가능
		model.addAttribute("board", boardService.detail(bno).get());
		model.addAttribute("reply", replyService.selectAll(bno));
		return "board/detailForm";
	}
	
}
