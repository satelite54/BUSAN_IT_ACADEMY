package java_temp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)//jvm 실행시에 감지 할 수 있는 어노테이션
public @interface Count100 {// 사용자 정의 어노테이션
	
}
