import java.util.Scanner;
import java.util.Stack;

public class Stack2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        
        while(n --> 0) {
        	boolean VPS = true;
        	String str = sc.nextLine();
        	Stack<Character> stack = new Stack<>();
        	for(int i = 0; i < str.length(); i++) {
        		if(str.charAt(i) == '(') {
        			stack.push(str.charAt(i));
        		}
        		if(str.charAt(i) == ')') {
        			if(stack.isEmpty()) {
        				VPS = false;
        				break;
        			}
        				stack.pop();
        		}
        	}
        	if(VPS && stack.isEmpty())
        		System.out.println("YES");
        	else {
        		System.out.println("NO");
        	}
        }
    }
}
