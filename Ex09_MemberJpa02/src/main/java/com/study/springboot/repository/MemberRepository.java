package com.study.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	/* findBy 뒤에 컬럼명을 붙여주면 된다.
	 컬럼의 조건이 여러개 일때 : And, Or 를 붙여주면 됨
	 
	 예제) 이름이 더조은 이거나 이메일이 test1@test.com
	  	= > findByNameOrEmail(String name, Strign email)
	 예제) 이름이 더조은 이면서 이메일이 test1@test.com
	  	= > findByNameAndEmail(String name, Strign email)
	
	*/
	Optional<Member> findByName(String name); // 자료형(Bean), PK 자료형
	Optional<Member> findByEmail(String email);
	
	//다양한 확장가능
	List<Member> findByNameLike(String name2);
	List<Member> findByNameLikeOrderByNameDesc(String name2);
	List<Member> findByNameLike(String name2, Sort sort);

}
