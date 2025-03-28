package exam1;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaUse1 {

	public static void main(String[] args) {
		// META-INF 아래에 있는 persistance.xml 파일에 있는 persistence-unit name="JpaEx01"
		// JPA 환경설정 불러오기
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01"); 
		// 실제 DB와 연결하여 CRUD
		EntityManager em = emf.createEntityManager();
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();
		
		try {
			ts.begin(); // 트랜잭션 시작
			
			// 테이블을 만들고 동시에 아래 2가지를 데이터를 전달
			Member1 user = new Member1("홍길동", LocalDate.now());
			
			// .persist() 영속성으로 객체에 데이터 입력(메모리에 insert 해주는 부분)
			em.persist(user);
			
			// db에 create table, insert
			ts.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
