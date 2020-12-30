package chap04;
import java.util.*;

public class StackExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStack stack1 = new IntStack(10);
		Stack<String> stack = new Stack<>();
		
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		stack1.push(6);
		stack1.dump();
		stack1.pop();
		stack1.dump();
		
		System.out.println(stack1.isEmpty());
		System.out.println(stack1.isFull());
		System.out.println(stack1.size());
		
		Gstack<Integer> gstack = new Gstack<>(4);
		Integer Oint = 1;
		gstack.push(Oint);
		gstack.push(Oint);
		gstack.push(Oint);
		gstack.push(Oint);
		gstack.pop();
		System.out.println(gstack.size());
		gstack.dump();
	}
}
