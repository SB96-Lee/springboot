package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("loginUser") // loginUser를 세션에 저장하도록 설정
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder pEncoder;
	
	
	@Autowired
	HttpSession session; // @SessionAttributes("loginUser") 모델에 안넣고 세션으로 넣을려고 할 경우
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/enrollForm")
	public String enrollForm() {
		return "member/enrollForm";
	}
	
	@GetMapping("/idCheck")
	public @ResponseBody boolean idCheck(@RequestParam("id") String id) { //@ResponseBody를 안넣으면 html 위치로 찾아가는거임
		return memberService.idCheck(id);
	}
	
	@PostMapping("/memberInsert")
	public String insert(Member member) {
		String enPass = pEncoder.encode(member.getPassword());
		member.setPassword(enPass);
		
		Member m = memberService.insert(member);		
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member loginUser = memberService.login(member);
	 
	    if (loginUser != null && pEncoder.matches(member.getPassword(), loginUser.getPassword())) {
	        // 비밀번호가 일치하면 로그인 성공 / 비교확인 : pEncoder.matches("사용자가 넣은 패스워드, DB에서 가져온 암호화 패스워드)
	        model.addAttribute("loginUser", loginUser);  
	        // request scope -> session scope로 변환
	        // 클래스에 어노테이션 추가 : @SessionAttributes({"loginUser", "여러개일 경우"})
	    }
	    return "redirect:/";  // 홈 페이지로 리다이렉트
	   
	}
	
	/*
	 * @SessionAttributes + model을 통해 로그인 정보를 관리하는 경우
	 	SessionStatus객체를 통해 사용완료 처리를 해야 함. => session.invalidate(); 로는 불가
	 	- session 객체를 폐기하지 않고 재사용
	 * 
	 */
    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(SessionStatus status) {
    	if(!status.isComplete()) { 
    		status.setComplete();
    	}
        return "redirect:/";  // 홈 페이지로 리다이렉트
    }

}
