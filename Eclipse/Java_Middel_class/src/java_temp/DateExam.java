package java_temp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {//지역화에 대한 고려가 되지 않음 jdk 1.0 부터 있었음
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date.toString());
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");// 생성자의 인자에 표현하고 싶은 값을 주면됨
		// 월은 MM 대문자 써야함 a는 오전 오후 표시 // zzz은 표준시간 표시
		
		System.out.println(ft.format(date));
		System.out.println(date.getTime());//long으로 시간을 리턴
		long today = System.currentTimeMillis();
		System.out.println(today);//long으로 현재 시스템 시간을 리턴
		
		System.out.println(today - date.getTime());//시간에 대한 연산도 가능
	}
}
