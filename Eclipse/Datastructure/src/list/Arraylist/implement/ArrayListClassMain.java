package list.Arraylist.implement;

import java.util.Scanner;

public class ArrayListClassMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.next();
        String str = String.format("%x", num);
        str.toUpperCase();
        System.out.printf(str);
    }
}