package testPjt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Bean 설정 파일 (XML 파일을 대체)임을 알려줌
@ComponentScan // IOC 컨테이너에 담을 bean들을 찾는다.
public class ApplicationConfig {
}
