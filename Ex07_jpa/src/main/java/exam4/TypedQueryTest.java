package exam4;

import java.util.List;

import jakarta.persistence.*;

public class TypedQueryTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01"); 
		EntityManager em = emf.createEntityManager();
		
		/*
		 * TypedQuery 클래스 : sql문을 직접 작성하고자 할때
		   - 영속성에서 객체에 넣을 구문 jpa문법
		    > select * => *을 사용할 수 없음. 테이블의 별칭을 이용하여 사용 
		 */
		try {
		em.getTransaction().begin();
		TypedQuery<Member4> query = em.createQuery("select m from Member4 m order by m.name", Member4.class); 
		
		List<Member4> list = query.getResultList();
		
		em.getTransaction().commit();
		
		if(list.isEmpty()) {
			System.out.println("테이블이 비어 있습니다");
		} else {
			list.forEach(user -> System.out.println(user.getEmail() + "/" + user.getName()));
		}
		
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}

}
