package LeetCode;

public class reverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} // int 형 자료형이 들어오면 역순으로 출력 예: input 321 output 123
	//input -123 output -321 
	//input 210 output 12
	//input 0 output 0
	public static int reversInteger (int x) {
		// dwadwa
		String str;
		if(x < 0) {
			//String은 특정위치에 문자 삽입 불가하다.
			//그래서 StringBuilder를 사용했다.
			str = Integer.toString(Math.abs(x)); // 절대값
		}
		else {
			str = Integer.toString(x);
		}
		char tempChar = ' ';
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {// 역순으로 변경
			tempChar = str.charAt(i);
			sb.append(str.charAt(str.length() - 1 - i));
		}
		if(x < 0) {
			sb.insert(0, '-');
		}
		int result;
		try {
			result = Integer.parseInt(sb.toString());
		} catch (Exception e) {
			return 0;
		}
		return result;
	}
}

class SolutionOtherPeople {
    public int reverse(int x) {
        String ans = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
                : new StringBuilder(String.valueOf(x)).reverse().toString();
        try { // String.valueof(x) 입력값을
            return Integer.parseInt(ans);
        } catch (Exception e) {
            return 0;
        }
    }
}

class SolutionInt { // int 형으로 푸는 방법
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

///We want to repeatedly "pop" the last digit off of xx and "push" it to the back of the rev. In the end, rev will be the reverse of the xx.
//우리는 xx의 마지막 숫자를 "팝업"하고 그것을 rev의 뒤에 "푸시"하기를 반복해서 원한다. 결국 rev는 xx의 역이 될 것이다.
