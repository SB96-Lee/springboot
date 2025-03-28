package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam("username") String name, Model model) {
		/*
		Member member2 = new Member();
		member2.setUsername(name);
		member2.setCreateDate(LocalDate.now());
		*/
		
		Member member = Member.builder()
							  .username(name)
							  .createDate(LocalDate.now())
							  .build();
		
		Member result = memberService.insert(member);
		
		model.addAttribute("member", result);
		
		return "insert";
	}
	
	@RequestMapping("select")
	public String select(@RequestParam("id") Long id, Model model) {
		/*
		 * Optional<T> : NullpointerException 발생을 방지하기 위해
		  				기존의 반환 값 타입 T에 Optional<T>를 wrapping하여,
		  				null 대신 Optional안에 빈 타입 객체를 돌려주는 기법
		  				
		  	ex) Member member = memberRepository.findById("usr01"); => 없는 아이디
		  		member.getUsername(); => NullpointerException
		 */
		Optional<Member> result = memberService.select(id);
		
		if(result.isPresent()) { // == isEmpty() : 데이터 있는지 없는지 체크 있으면 true
			model.addAttribute("member", result.get()); // 값을 넘길려면 Optional을 한꺼풀 풀어줌
		} else {
			model.addAttribute("member", null);
		}
		
		
		return "select";
	}
	
	@RequestMapping("selectAll")
	public String selectAll(Model model) {
		List<Member> list = memberService.selectAll();
		model.addAttribute("members", list);
		return "selectAll";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id);
		return "redirect:selectAll";
	}
	
	@RequestMapping("update")
	public String update(@RequestParam("id")Long id, 
						 @RequestParam("username") String username
						 , Model model) {
		
		Member m = Member.builder()
				  .id(id)
				  .username(username)
				  .createDate(LocalDate.now())
				  .build();
		
		Member member = memberService.update(m);
		model.addAttribute("member", member);
		return "update";
	}
}
