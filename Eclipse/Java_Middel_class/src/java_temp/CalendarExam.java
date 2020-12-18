package java_temp;
import java.util.Calendar;

public class CalendarExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance(); // Calender는 미 완성된 추상클래스
		// Calendar는 그레고리안 Calendar라는 자식 클래스를 가지고 있음.
		// getInstance()하면 그레고리안 Calendar가 리턴 될 수 있다.
		// 이렇게 구현한 이유는 나중에 달력 기준이 바뀔 때 까지 고려한거임.
		// 자바 업그레이드 될 때 달력 기준이 바뀌어 있다면 기존 그레고리안 대신 다른 달력 기준을
		// 인스턴스화하면 되니까.
		System.out.println(cal.get(Calendar.YEAR));// 클래스 상수를 이용해서 값을 가져옴
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		
		cal.add(Calendar.HOUR, 5);//원하는 시간으로 시간을 바꿀 수 있다.
		// 현재시간에서 5시간 이후로 세팅
		System.out.println(cal.get(Calendar.HOUR));
	}

}
