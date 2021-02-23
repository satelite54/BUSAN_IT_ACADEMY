package MakeSpringManual;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		Riding riding = (Riding) context.getBean(Riding.class);
		riding.Ride();
	}
} 
