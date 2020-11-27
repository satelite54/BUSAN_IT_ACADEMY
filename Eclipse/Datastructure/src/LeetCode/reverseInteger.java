package LeetCode;

public class reverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} // int �� �ڷ����� ������ �������� ��� ��: input 321 output 123
	//input -123 output -321 
	//input 210 output 12
	//input 0 output 0
	public static int reversInteger (int x) {
		// dwadwa
		String str;
		if(x < 0) {
			//String�� Ư����ġ�� ���� ���� �Ұ��ϴ�.
			//�׷��� StringBuilder�� ����ߴ�.
			str = Integer.toString(Math.abs(x)); // ���밪
		}
		else {
			str = Integer.toString(x);
		}
		char tempChar = ' ';
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {// �������� ����
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
        try { // String.valueof(x) �Է°���
            return Integer.parseInt(ans);
        } catch (Exception e) {
            return 0;
        }
    }
}

class SolutionInt { // int ������ Ǫ�� ���
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
//�츮�� xx�� ������ ���ڸ� "�˾�"�ϰ� �װ��� rev�� �ڿ� "Ǫ��"�ϱ⸦ �ݺ��ؼ� ���Ѵ�. �ᱹ rev�� xx�� ���� �� ���̴�.
