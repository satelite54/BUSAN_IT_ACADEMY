package java_temp;

import java.lang.reflect.Method; // 메소드의 정보를 알 수 있는 클래스

public class MyHellowExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myhello hello = new Myhello();
		
		try {
			Method method = hello.getClass().getDeclaredMethod("hello");
			// getClass는 오브젝트 클래스가 가지고 있음.
			// 해당인스턴스를 만들때 사용한 클래스를 리턴
			// getDeclaredMethod
			
			if(method.isAnnotationPresent(Count100.class)) {
			// 특정 어노테이션이 메소드에 적용되어 있는지 알아 낼 수 있다.
			// 적용 되어 있으면 true
				for(int i = 0; i < 100; i++) {
					hello.hello();
					// 어노테이션이 적용 되어 있으면 100번 출력
				}
			} else {
				// 아니면 1번만
				hello.hello();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
