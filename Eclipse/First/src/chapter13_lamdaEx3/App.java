package chapter13_lamdaEx3;

import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) {
		// CTR + SHIFT + O => ���� Ŭ���� �ҷ�����
		List<Car> cars = Arrays.asList(
				new Car("����","�Ÿ", "����", 3200 ),
				new Car("����","�� ����", "��", 3100 ),
				new Car("����","�ƹݶ�", "���", 2500 ),
				new Car("���","ī�Ϲ�", "ȭ��Ʈ", 5000 ),
				new Car("���","���", "���", 3800 ),
				new Car("������","������", "��", 3000 ),
				new Car("������","����ũ", "����", 1200 ),
				new Car("����Ｚ","QM6", "�׷���", 3300 )				
				);
//		showCarPriceRange(cars, 2700, 3300);
//		showCarByColor(cars, "���");

		showCars(cars, new Condition() {			
			@Override
			public boolean test(Car c) {	
				return 2700 <= c.getPrice() && c.getPrice() <= 3300;
			}
		}); // �͸�ü ����
		
		showCars(cars, new Condition() {			
			@Override
			public boolean test(Car c) {	
				return c.getColor() == "���";
			}
		});
		
		() -> System.out.println("");
		
		showCars(cars, (c) -> 2700 <= c.getPrice() && c.getPrice() <= 3300 );
		showCars(cars, (c) -> c.getColor() == "���"); //���ڷ� ����
	}
	
	
	
	public static void showCars(List<Car> cars, Condition con) {
		for(Car c : cars) {
			if(con.test(c)) {
				c.printCar();
			}
		}
	}
	
//	public static void showCarPriceRange(List<Car> cars, int low, int high) {
//		for(Car c: cars) {
//			if(low <= c.getPrice() && c.getPrice() <= high) {
//				c.printCar();
//			}
//		}
//	}
//	
//	public static void showCarByColor(List<Car> cars, String color) {
//		for(Car c: cars) {
//			if(c.getColor() == color) {
//				c.printCar();
//			}
//		}
//	}
}