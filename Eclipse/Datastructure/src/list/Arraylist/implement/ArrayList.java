package list.Arraylist.implement;
import java.util.Scanner;

public class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100];
	
	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
		return true;
	}
}