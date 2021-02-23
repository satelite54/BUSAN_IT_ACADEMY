package testPjt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component // 런타임에 IOC 컨테이너에 Bean을 주입
// Componet 어노테이션의 경우 디폴트 생성자를 찾는다. 생성자 있을 경우에 빈 주입 불가.
// @Configuration ,@Bean을 이용해 Bean을 주입하는 방법도 있다.
public class TransportationWalk {
	String name;
	
//	@Autowired // 객체 생성 지점에 스프링 컨테이너에서 해당 스프링 빈 찾아서 주입
//	// 생성자가 1개만 있으면 생략가능
//	public TransportationWalk(String name) {
//		this.name = name;
//	}

	public void move(){
		System.out.println("도보로 이동합니다.");
	}
}