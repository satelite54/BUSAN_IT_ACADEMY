package MakeSpringManual;

import org.springframework.stereotype.Component;

@Component //기본 생성자가 없으면 죽여버린다.. 왜?
public class Riding {
	String bikeName;
	String personName;
	
	public Riding() {
		
	}
	public Riding(String bikeName, String personName) {
		this.bikeName = bikeName;
		this.personName = personName;
	}
	
	public void Ride() {
		System.out.println(personName +"은 "+ bikeName +"를 탑니다.");
	}
}
