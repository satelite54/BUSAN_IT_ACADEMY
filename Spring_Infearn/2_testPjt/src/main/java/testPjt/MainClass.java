package testPjt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		일반적인 자바의 객체 생성
//		TransportationWalk transportationWalk = new TransportationWalk();
//		transportationWalk.move(); 

		//applicationContext.xml을 이용해 IOC 컨테이너에 접근하는 방법
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpth:applicationContext.xml");  // 스프링 컨테이너에 접근하는 방법
//		TransportationWalk transportationWalk = ctx.getBean("tWalk", TransportationWalk.class);//컨테이너에 있는 빈을 가져온당
//		transportationWalk.move();
//		ctx.close();
		
// 		어노테이션 기반으로 Bean들을 등록하기 위해서는 AnnotaionConfigApplicationContext를 이용
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// 이제 IOC 컨테이너에 빈이 올라감
		
		TransportationWalk transportationWalk = (TransportationWalk) context.getBean(TransportationWalk.class);
		transportationWalk.move();
	}
}
