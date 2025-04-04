package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("selectNameLike")
	public String selectNameLike(@RequestParam("name") String name
								,@RequestParam("page") String page 
								, Model model) {
		
		String name2 = name + "%";
		int nPage = Integer.parseInt(page) - 1;
		/*
		 * Pageable 인터페이스
		 	: Spring에서는 Pagenation을 지원하는 인터페이스 제공
		 	- getPageNumber() : 현재 페이지 번호를 반환(0부터 시작)
		 	- getPageSize() : 한 페이지당 레코드 수를 반환
		 	- getOffset() : 현재 페이지의 시작 위치를 반환
		 	- getSort() : 정렬 정보를 반환
		 	- next()  : 다음 페이지 정보를 반환
		 	- previous() : 이전 페이지 정보를 반환
		 	
		 * PageRequest 클래스
		   : Spring Data JPA에서 제공하는 pageable 구현체 중 하나, 페이지 정보를 생성하는 클래스
		   - page : 조회할 페이지 번호(0부터 시작)
		   - size : 한 페이지당 최대 레코드 수
		   - sort : 정렬정도(생략가능)
		   - direction : 정렬방향(asc, desc)
		   - properties : 정렬 대상 속성명	
		 
		 > 생성자
		 	PageRequest(int page, int size) 필수
		 	PageRequest(int page, int size, Sort sort)
		 	PageRequest(int page, int size, Sort.Direction direction, String.. properties)
		 */
		
		/* 페이지 처리 기본
		PageRequest.ofSize(10)
					.withPage(nPage)
					.withSort(null);
		
		OR
		
		Pageable pageable = PageRequest.of(nPage, 10); // 한 페이지 당 10개 라는 뜻 (생성자 이용해서 생성)
		*/
		
		// 이름 내림차순 정렬하여 1Page에 해당하는 레코드 가져오기
		Sort sort = Sort.by(Sort.Order.desc("name"));
		Pageable pageable = PageRequest.of(nPage, 10, sort); // 이름으로 내림차순 정렬하여 10페이지
		//Pageable pageable = PageRequest.of(nPage, 10, Sort.by("name").descending()); 내림차
		//Pageable pageable = PageRequest.of(nPage, 10, Sort.by("name").ascending()); 오름차
	
		Page<Member> result = memberService.selectNameLike(name2, pageable);
		// Page : 단순히 리스트(List<T>)만 반환하는 것이 아니라, 총 페이지 수, 현재 페이지 번호, 전체 데이터 개수 등의 정보를 함께 제공
		List<Member> member = result.getContent();	// 실제 객체가 담긴 List<Member>
		long totalElements = result.getTotalElements(); // 총 레코드 수(23개)
		int totalPages = result.getTotalPages(); // 총 페이지 수(3 페이지)
		int size = result.getSize();		// 한 페이지당 최대 레코드 수(10개)
		int pageNumber = result.getNumber() + 1; // 현재페이지(0부터 시작하므로 + 1)
		int numberofElements = result.getNumberOfElements(); // 현재페이지의 content 개수
		
		model.addAttribute("members", member);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("numberofElements", numberofElements);
		
		return "selectListPage";
	}
	
}