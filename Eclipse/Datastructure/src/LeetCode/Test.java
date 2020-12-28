package LeetCode;

import java.awt.RenderingHints.Key;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Util.CLog;
import Util.CPrint;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,2,1,3};
		solution38My(5, a);
	}
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
    public static int maximumWealthMy(int[][] accounts) {
        int sum = 0;
        int result = 0;
        for(int i = 0; i < accounts.length; i++) {
            for(int j = 0; j < accounts[i].length; j++){
                sum += accounts[i][j];
            }
            if(result < sum)
                result = sum;
            sum = 0;
        }
        return result;
    }
    
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).mapToInt(i -> Arrays.stream(i).sum()).max().getAsInt();
    // IntStream 형으로 변환하고(mapToint) + 람다식을 이용하면 스트림을 순회할 수 있다.
    // 람다식에서 입력매개변수를 i로 정하고 stream(i)번째에 합계를 구하고, 최대값을 getAsInt() Int값을 받겠다.
    // 이렇게도 풀리는 구나.
    }
    
    public List<Boolean> kidsWithCandiesMy(int[] candies, int extraCandies) {
    	int max = Arrays.stream(candies).max().getAsInt();
    	ArrayList<Boolean> bAryList = new ArrayList<>();
    	for(int i = 0; i < candies.length; i++) {
    		if(candies[i] + extraCandies >= max) {
    			bAryList.add(true);
    		}
    		else 
    			bAryList.add(false);
    	}
    	return bAryList;
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        
        List<Boolean> res = new ArrayList();
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
//    Java O(n) solution
    
    public int[] runningSum(int[] nums) {
    	for(int i = 0; i < nums.length - 1; i++) {
    		nums[i + 1] = nums[i + 1] + nums[i];
    	}
    	return nums;
    }
    
    public int[] shuffleMy(int[] nums, int n) {
    	int [] nums1 = Arrays.copyOfRange(nums, 0, n - 1);
    	int [] nums2 = Arrays.copyOfRange(nums, n, n * 2 - 1);

        for(int i = 0; i < nums.length; i += 2) {
        	nums[i] = nums1[i/2];
        	nums[i + 1] = nums2[i/2];
        }
        return nums;
    }
    // [2, 5, 1] [3, 4, 7]
    // 복잡하게 생각했다... 배열을 쪼개서 차례대로 넣을려고 함 ㅋㅋ 그럴 필요없는데..
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int j = n;
        int i = 0;
        for(int k = 0;k<nums.length;k++){
            if(k%2==0){
                result[k] = nums[i++];
            }
            else{
                result[k] = nums[j++];
            }
        }
        return result;
    }
    
    public static String defangIPaddrMy(String address) {
    	String[] strAry = new String[address.length()];
    	
    	strAry = address.split("\\.");
    	ArrayList<String> strAryList = new ArrayList<>();
    	for(int i = 0; i < strAry.length; i++) {
    		strAryList.add(strAry[i]);
    		if(i == strAry.length - 1)
    			break;
    		strAryList.add("[.]");
    	}
    	String str = "";
    	for(int i = 0; i < strAryList.size(); i++) {
    		str += strAryList.get(i);
    	}
    	return str;
    }
    
    public static String defangIPaddr(String address) { // StringBuilder를 이용한 풀이 방법
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++){
            char c = address.charAt(i);
            if (c == '.') sb.append("[.]");
            else sb.append(c);
        }
        return sb.toString();
    }
    
//    public int numIdenticalPairs(int[] nums) {
//        
//    }
    public int numJewelsInStonesMy(String J, String S) {
        int Cnt = 0;
    	for(int i = 0; i < J.length(); i++) {
        	char c = J.charAt(i);
        	for(int j = 0; j < S.length(); j++) {
        		if(c == S.charAt(j)) {
        			++Cnt;
        		}
        	}
        }
    	return Cnt;
    }
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewelsSet = new HashSet<>();
        for (int i = 0; i < J.length(); ++i)
            jewelsSet.add(J.charAt(i));
        int res = 0;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (jewelsSet.contains(ch))
                ++res;
        }
        return res;
    }
    // Hashset을 이용한 풀이
    
    public static boolean arrayStringsAreEqualMy(String[] word1, String[] word2) {
    	StringBuilder strB1 = new StringBuilder();
    	StringBuilder strB2 = new StringBuilder();
    	for(int i = 0; i < word1.length; i++) {
    		strB1.append(word1[i].toString());
    	}
    	for(int i = 0; i < word2.length; i++) {
    		strB2.append(word2[i].toString());
    	}
    	System.out.println(strB1.toString());
    	System.out.println(strB2.toString());
//    	if(strB1.toString() == strB2.toString()) // == 비교하고자 하는 대사의 주소값을 비교
    	if(strB1.toString().equals(strB2.toString()))	
    		return true;
    	return false;
    } // 엄청 느리다. ㅋㅋ // 왜 느리지?
    // 빠르게 한번 더 풀어보자.
    public static boolean arrayStringsAreEqualMy1(String [] word1, String[] word2) {
		String str1 = "";
		String str2 = "";
    	for(int i = 0; i < word1.length; i++) {
			str1 += word1[i];
		}
    	for(int i = 0; i < word2.length; i++) {
			str2 += word2[i];
		}
    	if(str1.equals(str2))
    		return true;
    	return false;
	}
    // 조금 더 빠른데 // 더 빨리 풀 수 있는 방법이 있나?
    
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return (String.join("",  word1)).equals(String.join("",  word2));
    } // 오 쉣 한줄로도 풀리는 솔루션이 있다.
    // String 클래스에 join을 사용하면 String 일차원 배열을 붙여서 String으로 리턴해주나보다. 좋네
    
    class ParkingSystemMy {// 다른 사람들도 거의 다 비슷하게 풀었다.

        int big;
        int medium;
        int small;
        
        public ParkingSystemMy(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }
        
        public boolean addCar(int carType) {
            switch(carType) {
              case 1:
                if(big == 0)
                    return false;
                --big;    
                return true;
              case 2:
                if(medium == 0)
                    return false;
                --medium;    
                return true;
              case 3:
               if(small == 0)
                    return false;
                --small;
                return true;
              default:
                return false;
            }
        }
    }
    
    public static int numberOfStepsMy (int num) {
        int Cnt = 0;
        while(num > 0) {
            if(num % 2 == 0) {
                num /= 2;
                ++Cnt;
            }
            else {
                num -= 1;
                ++Cnt;
            }
        }
        return Cnt;
    } // 다른 사람들도 다 비슷하게 풀었다.
    public static int[] smallerNumbersThanCurrentMy(int[] nums) {
    // 배열 속에 작은 값이 몇개 있는지?
        int[] nAry = Arrays.copyOf(nums, nums.length);
        int[] nResult = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	int Cnt = 0;
        	for(int j = 0; j < nums.length; j++) {
        		if(nAry[j] < nums[i])
        			++Cnt;
        	}
        	nResult[i] = Cnt;
        }
        return nResult;
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = nums.clone(); // 오 이것도 배열을 복사하는 방법이구나
        Arrays.sort(ans); //Arrays 클래스의 sort 메소드를 통해 정렬한다.
        
        Map<Integer, Integer> indexs = new HashMap<>();//해시맵 선언
        for(int i = 0; i < ans.length; i++){
            if(!indexs.containsKey(ans[i])){ //키값을 보유하고 있지 않으면
                indexs.put(ans[i], i);//키는 ans[i], i의 값을 넣어 준다.
                // 이때 i가 갯수이다.
                
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            ans[i] = indexs.get(nums[i]); // 갯수를 리턴해준다.
        }
        return ans;
    }
    
    public static String restoreStringMy(String s, int[] indices) {
    	Map<Integer, Character> Map = new HashMap<>();
    	for(int i = 0; i < indices.length; i++) {
    		Map.put(indices[i], s.charAt(i));
    	}
    	String str = "";
    	for(int i = 0; i < indices.length; i++) {
    		str += Map.get(i);
    	}
    	return str; // 느리다 ㅠㅠ 좀더 효율적으로 푸는 방법이 있나?
    }
    public static String restoreString(String s, int[] indices)
    {
        char[] arr = s.toCharArray(), res = new char[arr.length];
        for(int x = 0; x < arr.length; x++)
            res[indices[x]] = arr[x];
        return new String(res); //오 스트링 생성자 호출할 때 charArray 넣어주면 String으로 합쳐주네.
    }
    
    public int subtractProductAndSumMy(int n) {
        String str = Integer.toString(n);
        String[] strAry = new String[str.length()];
    	strAry = str.split("");
    	int tempProduct = 1;
    	int tempSum = 0;
    	for(int i = 0; i < strAry.length; i++) {
    		tempProduct *= Integer.parseInt(strAry[i]);
    		tempSum += Integer.parseInt(strAry[i]);
    	}
    	return tempProduct - tempSum;
    } // 진짜 느리네.. 6%다.
    
    public int subtractProductAndSum(int num) {
        int product = 1, sum = 0;
        while(num != 0){
            int digit = num%10;
            num /= 10;
            product *= digit; 
            sum += digit;
        }
        return product- sum;
    } // 숫자로 생각해서 풀 때
    public int subtractProductAndSum2(int n) {
        String N = Integer.toString(n);
        int product = 1;
        int sum = 0;
        for (char c : N.toCharArray()) {
            
            product *= Character.getNumericValue((int)c);
            sum += Character.getNumericValue((int)c);
        }
        return product - sum;
    } // String 으로 풀 때 오~~~
    
    public int[] decompressRLElistMy(int[] nums) {
    	ArrayList<Integer> nArayList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
        	int getCnt = nums[i];
        	if(i % 2 == 0) {
        		for(int j = 0; j < getCnt; j++) {
        			nArayList.add(nums[i + 1]);        			
        		}
        	}
        }
        return nArayList.stream().mapToInt(i -> i).toArray(); // 스트림을 이용해서 int[]로 변환
    }// 6ms
    
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for(int i=0; i<nums.length; i+=2)
        {
            size += nums[i];
        }
        
        int[] res = new int[size];
        int index = 0;
        
        for(int i=1; i<nums.length; i+=2)
        {
            int occurrences = nums[i-1];
            int value = nums[i];
            
            while(occurrences-- != 0)
            {
                res[index++] = value;
            }
        }
        
        return res;
    } // 1ms
    
    public static int[] createTargetArray(int[] nums, int[] index) {
    	ArrayList<Integer> nAryList = new ArrayList<>();
    	for(int i = 0; i < nums.length; i++) {
    		nAryList.add(index[i], nums[i]);
    	}
    	return nAryList.stream().mapToInt(i -> i).toArray();
    }
    // 속도 100% ...
    public static int numberOfMatchesMy(int n) {
    	int result = 0;
    	while(n != 1) {
    		result += n / 2;
    		n = n - (n / 2);
    	}
    	return result;
    }
    public static int maxDepth(String s) {

//    	Stream<Character> charcterstream = s.chars().mapToObj(c -> (char) c);
//    	Character charobj = charcterstream.max(Character::compare).get();
//    	System.out.println(charobj);
        // 오 수식이 주어졌을 때 스트링에서 가장 높은 정수 값을 찾는 방법이다.
        // 아스키 코드표를 잘 알아야 활용할 수 있을 듯.
    	int Cnt = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
        	int CharInt = s.charAt(i);
        	if(CharInt == 40) {
        		++Cnt;
        		if(max < Cnt)
        			max = Cnt;
        	} else if(CharInt == 41){
				--Cnt;
			}
        }
        System.out.println(max);
    	return max; 
    }
    
    public static int balancedStringSplit(String s) {
        int count = 0;
        int lCount = 0;
        int rCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R') {
                rCount++;
            } else {
                lCount++;
            }
            if(lCount == rCount) {
                count++;
                lCount=0;
                rCount=0;
            }
        }
        return count;
    }
    public static int xorOperation(int n, int start) {
        int[] nAry = new int[n];
        for(int i = 0; i < n; i++) {
            nAry[i] = start + 2 * i;
        }
        int result = 0;
        for(int j = 0; j < n; j++) {
            result = result ^ nAry[j];
        }
        return result;
    }
    
    public class TreeNode {
    	      int val;
    	      TreeNode left; // 자식노드 왼쪽
    	      TreeNode right; // 자식노드 오른쪽
    	      TreeNode() {}
    	      TreeNode(int val) { this.val = val; }
    	      TreeNode(int val, TreeNode left, TreeNode right) {
    	          this.val = val;
    	          this.left = left;
    	          this.right = right;
    	      }
    	  }
    // 이진탐색트리
    // 각 노드의 자식이 2개 이하인 트리
    // 왼쪽 자식은 부모보다 작고, 오르쪽 자식은 부모보다 큼
    // 아직 모르겠다 ㅠㅠ 자료구조 공부를 더해야할 듯..
    public int rangeSumBST(TreeNode root, int L, int R) {
    	int sum = 0;
        if(root == null)
            return 0;
    
        if(root.val >= L && root.val <= R ){
             sum += root.val;
             rangeSumBST(root.left,L,R);
             rangeSumBST(root.right,L,R);
        }
        else if(root.val < L)
            rangeSumBST(root.right,L,R);
        else if(root.val > R)
            rangeSumBST(root.left,L,R);
    return sum;
    }
    
    class OrderedStream {
    	String[] data;
		int idx;
		
		public OrderedStream(int n) {
			data = new String[n + 1];
			idx = 1;
		}

		public List<String> insert(int id, String value) {
			data[id] = value;
			List<String> out = new ArrayList<>();
			if (data[idx] == null)
				return out;
			while (id < data.length && data[id] != null) {
				out.add(data[id++]);
				idx++;
			}
			return out;
		}
    }
    
//    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public int getDecimalValue(ListNode head) {
    	int value = 0;
    	while(head != null) {
    		value = value << 1 | head.val;
    		head = head.next;
    	}
    	return value;
    }
    public int getDecimalValue1(ListNode head) {
        if(head == null){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int res = 0;
        for(int i=0;i<list.size();i++){
            res = ((res<<1)|list.get(i)); 
        }
        
        return res;
    }
    public static int sumOddLengthSubarrays(int[] arr) {
        
    	// 5, 3, 1 번 반복
    	int Arynanugi = 0;
    	for(int i = 0; i < arr.length; i++) {
    		
    	}
    	
    	return Arynanugi;
    }
    public static String toLowerCase(String str) {
    	return str.toLowerCase();
    }
    // 카카오 크레인 인형뽑기 게임
    public static int solution1My(int[][] board, int[] moves) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < moves.length; i++) {
        	for(int j = 0; j < board.length; j++) {
        		if(board[j][moves[i] - 1] > 0) {
        			list.add(board[j][moves[i] - 1]);
        			if(list.size() >= 2) {
        				if(list.get(list.size() - 2).equals(list.get(list.size() - 1))) {
        					list.remove(list.size() - 2);
        					list.remove(list.size() - 1);
        					++answer;
        				}
        			}
        			board[j][moves[i] - 1] = 0;
        			break;
        		}
        	}
        }
        
        return answer * 2;
    }
    public int solution1(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    // 두 개 뽑아서 더하기
    public static int[] solution2My(int[] numbers) {

    	Set<Integer> hashset = new HashSet<Integer>();
    	
    	for(int i = 0; i < numbers.length; i++) {
    		for(int j = numbers.length - 1; j >= 0; j--) {
    			if(i == j)
    				continue;
    			hashset.add(numbers[i] + numbers[j]);
    		}
    	}
    	int[] nAry = new int[hashset.size()];
    	Iterator<Integer> iter = hashset.iterator();
    	int i = 0;
    	while(iter.hasNext()) {
    		nAry[i] = iter.next();
    		i++;
    	}
    	Arrays.sort(nAry);
    	
        return nAry;
    }
    // 완주하지 못한 선수 Hash
    public static String solution3My(String[] participant, String[] completion) {
//    	 List<String> list = new ArrayList<>(Arrays.asList(participant));
//    	 for(int i = 0; i < completion.length; i++) {
//    	 	list.remove(completion[i]);
//    	 }
//    	 return list.get(0);
    	for(int i = 0; i < participant.length; i++) {
    		for(int j = 0; j < completion.length; j++) {
    			if(participant[i].equals(completion[j])) {
    				participant[i] = "";
    				completion[j] = "";
    			}
    		}
    	}
    	String result = "";
    	for(int j = 0; j < participant.length; j++ ) {
        	if(!participant[j].equals("")) {
    			result = participant[j];
    		}
    	}
    	return result;
    }
    public static String solution3(String[] participant, String[] completion) {
        String result = "";
        String temp = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
 
//        int i = 0;
        
//        while(i < completion.length){
//            if(!completion[i].equals(participant[i])){
//                temp = participant[i];
//                break;
//            }else{
//                i++;
//            }
//        }
        for(int i = 0; i < completion.length; i++) {
        	if(!completion[i].equals(participant[i])) {
        		temp = participant[i];
        		break;
        	}
        }
        
        if(!temp.equals("")){
        	result = temp;
        }else{
        	result = participant[participant.length-1];
        }
        
        return result;
	}
    // 수포자 모의고사 ㅠㅠ
    public static int[] solution4(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int person1Score= 0;
        int person2Score= 0;        
        int person3Score= 0;
        
        int person1namogi = 0;
        person1namogi = answers.length % person1.length;
        int person2namogi = 0;
        person2namogi = answers.length % person2.length;
        int person3namogi = 0;
        person3namogi = answers.length % person3.length;
        
        List<Integer> AnswerSheet1 = new ArrayList<>();
        for(int i = 0; i < Math.floor(answers.length / person1.length); i++) {
        	for(int j = 0; j < person1.length; j++) {
        		AnswerSheet1.add(person1[j]);
        	}
        }
        List<Integer> AnswerSheet2 = new ArrayList<>();
        for(int i = 0; i < Math.floor(answers.length / person2.length); i++) {
        	for(int j = 0; j < person2.length; j++) {
        		AnswerSheet2.add(person2[j]);
        	}
        }
        List<Integer> AnswerSheet3 = new ArrayList<>();
        for(int i = 0; i < Math.floor(answers.length / person3.length); i++) {
        	for(int j = 0; j < person3.length; j++) {
        		AnswerSheet3.add(person3[j]);
        	}
        }
        
        for(int i = 0; i < person1namogi; i++) {
        	AnswerSheet1.add(person1[i]);
        }
        for(int i = 0; i < person2namogi; i++) {
        	AnswerSheet2.add(person2[i]);
        }
        for(int i = 0; i < person3namogi; i++) {
        	AnswerSheet3.add(person3[i]);
        }
        
        int totalCnt1 = 0;
        int totalCnt2 = 0;
        int totalCnt3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
        	if(answers[i] == AnswerSheet1.get(i)) {
        		totalCnt1++;
        	}
        	if(answers[i] == AnswerSheet2.get(i)) {
        		totalCnt2++;
        	}
        	if(answers[i] == AnswerSheet3.get(i)) {
        		totalCnt3++;
        	}
        }
        
        List<Integer> listLeast = new ArrayList<>();
        int maxCount = Math.max(totalCnt1, Math.max(totalCnt2, totalCnt3));
        if(maxCount == totalCnt1) listLeast.add(1);
        if(maxCount == totalCnt2) listLeast.add(2);
        if(maxCount == totalCnt3) listLeast.add(3);
        
        int[] result = new int[listLeast.size()];
        for(int i = 0; i < result.length; i++) {
        	result[i] = listLeast.get(i);
        }
        Arrays.sort(result);
        return result;
    }
    // 체육복
    public static int solution5My(int n, int[] lost, int[] reserve) {
    	// 탐욕법
    	int[] all = new int[n];

    	for (int i : reserve)
    		all[i - 1]++;

    	for (int i : lost)
    		all[i - 1]--;

    	for (int i = 0; i < all.length; i++)
    		if (all[i] < 0)
    			if (i != all.length - 1 && all[i + 1] > 0) {
    				all[i]++;
    				all[i + 1]--;
    			} else if (i != 0 && all[i - 1] > 0) {
    				all[i]++;
    				all[i - 1]--;
    			}

    	int answer = 0;

    	for (int i = 0; i < all.length; i++)
    		if (!(all[i] < 0))
    			answer++;

    	return answer;
    }
    public static int[] solution6My(int[] array, int[][] commands) {
    	int[] answer = new int[commands.length];
    	
    	for(int i = 0; i < commands.length; i++) {
    		int debug1= commands[i][0] - 1;
    		int debug2= commands[i][1] - 1;
    		
    		int[] nArytemp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
    		Arrays.sort(nArytemp);
    		answer[i] = nArytemp[commands[i][2] - 1];
    	}
    	
    	return answer;
    }
    public static String solution7My(int a, int b) {
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, 2016);
    	cal.set(Calendar.MONTH, a - 1);
    	cal.set(Calendar.DATE, b);
    	
    	String[] strAry = {"SUN", "MON", "TUE", "WED","THU", "FRI", "SAT"};
    	return strAry[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }
    
    public static int solution8My(int n) {
    	
//    	for(int i = 0; i < dno / 2; i++) {
//		char a;
//		a = cno[i];
//		cno[i] = cno[dno - 1 - i];
//		cno[dno - 1 - i] = a;
//	}
    	
    	int dno;
    	char[] cno = new char[32];
    	dno = cardConvR(n, 3, cno);
    	int result = 0;
    	for(int i = 0; i < dno - 1; i++) {
    		int temp = (int)Math.pow(3, i);
    		result += Character.getNumericValue(cno[dno - 1 - i]) * (int)Math.pow(3, i);
    	}
    	
    	return result;
    }
	
    public static int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);
			return digits;
	}
    
    public static String solution9My(String str) {
    	
    	char[] cAry = str.toCharArray();
    	String result = "";
    	if(cAry.length % 2 == 1) {
    		return Character.toString(cAry[cAry.length/2]);
    	} else {
    		return Character.toString(cAry[cAry.length/2 - 1]) + Character.toString(cAry[cAry.length/2]);
    	}
    }
    
    public static int[] solution10My(int[] arr) {
//    	Set<Integer> set = new HashSet<>();
//    	for(int i = 0; i < arr.length; i++) {
//    		set.add(arr[i]);
//    	}
//    	int[] result = new int[set.size()];
//    	Iterator<Integer> iter = set.iterator();
//    	int i = 0;
//    	while(iter.hasNext()) {
//    		result[i] = iter.next();
//    		i++;
//    	}
//    	
    	List<Integer> list = new ArrayList<Integer>();
    	// 처음 temp 값 지정
    	list.add(arr[0]);
    	for(int i = 0; i < arr.length - 1; i++) {
    		if(arr[i] == arr[i + 1]) {
    			continue;
    		} else {
				list.add(arr[i + 1]);
			}
    	}
    	
    	int[] result = new int[list.size()];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = list.get(i);
    	}
    	
    	return result;
    }
    public static int[] solution11My(int[] arr, int divisor) {
    	Arrays.sort(arr);
    	List<Integer> list = new ArrayList<>();
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] % divisor == 0) {
    			list.add(arr[i]);
    		}
    	}
        if(list.size() < 1) {
    		list.add(-1);
    	}
    	int[] result = new int[list.size()];

    	for(int i = 0; i < list.size(); i++) {
    		result[i] = list.get(i);
    	}

    	return result;
    }
    public static long solution12My(int a, int b) {
    	
    	int forCnt = Math.abs(Math.abs(a - b) + 1);
    	long resultsum = 0;
    	if(a > b) {
    		for(int i = 0; i < forCnt; i++) {
    			resultsum += b++;
    		}
    	} else if(a < b) {
    		for(int i = 0; i < forCnt; i++) {
    			resultsum += a++;
    		}
    	} else {
    		return a;
    	}
    	return resultsum;
    }
    public static String[] solution13My(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> myArr = new ArrayList<>();
        
        for(int i=0; i<strings.length; ++i)
            myArr.add("" + strings[i].charAt(n) + strings[i]);
        
        Collections.sort(myArr);
        answer = new String[myArr.size()];
        
        for(int i=0; i<myArr.size(); ++i)
            answer[i] = myArr.get(i).substring(1, myArr.get(i).length());
        
        return answer;
    }
    
    public boolean soultion14My(String s) {
		int pCnt = 0;
		int yCnt = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==80 || s.charAt(i)==112)
				++pCnt;
			 else if(s.charAt(i)==89 || s.charAt(i)== 121)
				++yCnt;
		}
		
		if(pCnt == yCnt)
			return true;
		else
			return false;
	}
    public boolean solution14(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
    public static String soultion15My (String s) {
    	// 내림차순 정렬
    	String[] strAry = s.split("");
    	return Stream.of(strAry).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
	}
    public static String solution15(String s) {
        String[] arrays = s.split("");

        Collections.sort(Arrays.asList(arrays), Collections.reverseOrder());

        return String.join("", arrays);
    }
    public static boolean solution16My(String s) {
    	
    	if(!(s.length() == 4 || s.length() == 6))
    		return false;
    	
        for(int i = 0; i < s.length(); i++) {
        	int temp;
        	temp = Character.getNumericValue(s.charAt(i));
            if((temp < 10 && temp >= 0) != true) {
            	return false;
            }
        }
        return true;
    }
    public static String solution17My(String[] seoul) {
//    	for(int i = 0; i < seoul.length; i++) {
//    		if(seoul[i].equals("Kim")) {
//    			return "김서방은 " + i + "에 있다";
//    		}
//    	}
    	// 왜 정렬하면 답이 안나올까??????
    	Arrays.sort(seoul);
    	Arrays.binarySearch(seoul, "Kim");
    	for(int i = 0; i < seoul.length; i++) {
    		if(seoul[i].equals("Kim")) {
    			return "김서방은 " + i + "에 있다";
    		}
    	}
    	
        return "-1";
    }
    public static int solution18My(int n) {
    	  // 입력받은 수 만큼 배열에 모두 초기화 해둔다

    	int[] arr = new int[n * n]; 
    	int Cnt = 0;
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        
        for (int i = 2; i <= n; i++) { 
            if (arr[i] == 0) // 이미 체크된 수의 배수는 확인하지 않는다
                continue;
            for (int j = i + i; j <= n; j += i) { // i를 제외한 i의 배수들은 0으로 체크
                arr[j] = 0;
            }
        }
        
        for(int i = 2; i <= n; i++) {
        	if(arr[i] != 0)
        		Cnt++;
        }
        return Cnt;
    }
    public static int solution19My(String s) {
    	return Integer.parseInt(s);
    }
    public static int solution20My(int[] a, int[] b) {
    	int result = 0;
    	for(int i = 0; i < a.length; i++) {
    		result += a[i]*b[i];
    	}
    	return result;
    }
    public static String solution21My(String s, int n) {
    	char[] cAry = s.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < cAry.length; i++) {
    		if(cAry[i] == ' ') {
    			sb.append(' ');
    			continue;
    		}
    		//대문자 처리
    		if(cAry[i] >= 'A' && cAry[i] <= 'Z') {
    			//만약 cAry에 n을 더 했을때 Z를 초과시
    			if(cAry[i] + n > 'Z') {
    				//초과한 만큼 A에 더해준다.
    				char a = (char)('A' + cAry[i] + n - 'Z' - 1);
    				sb.append(a);
    			} else {
    				sb.append((char)(cAry[i] + n));
    			} continue;
    		}
    		//소문자 처리
    		if(cAry[i] >= 'a' && cAry[i] <= 'z') {
    			if(cAry[i] + n > 'z') {
    				//초과한 만큼 A에 더해준다.
    				char a = (char)('a' + cAry[i] + n - 'z' - 1);
    				sb.append(a);
    			} else {
    				sb.append((char)(cAry[i] + n));
    			}
    		}
    	}
    	return sb.toString();
    }
    public static int solution22My(int n) {
        List list = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
        	if(n % i == 0)
        		list.add(i);
        }
        
        return list.stream().mapToInt(i -> (Integer)i).sum();
    }
	public static String solution23My(String s) {
    	
    	String[] strAry = s.split("");
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < strAry.length; i++) {
    		if(strAry.equals("") && i == 0) {
    			sb.append(" ");
    			continue;
    		}
    		if(strAry.equals("")) {
    			sb.append(" ");
    			continue;
    		}
    		for(int j = 0; j < strAry[i].length(); j++) {
    			if(j % 2 == 0) {
    				sb.append(Character.toUpperCase(strAry[i].charAt(j)));
    			} else {
    				sb.append(Character.toLowerCase(strAry[i].charAt(j)));
    			}
    		}
    	}
    	
    	return strAry.toString();
    }
	
	public static int solution24My(int n) {
		int result = 0;
		
		String[] strAry = Integer.toString(n).split("");
		
		for(int i = 0; i < strAry.length; i++) {
			result += Integer.parseInt(strAry[i]);
		}
		
		return result;
	}
	
	public static int[] solution25My(long n) {	
		String[] strAry = Long.toString(n).split("");
		int[] nAry = new int[strAry.length];
		int temp = strAry.length - 1;
		for(int i = 0; i < strAry.length; i++) {
			nAry[i] = Integer.parseInt(strAry[temp]);
			--temp;
		}
		
		return nAry;
	}
	public static long solution26My(long n) {		
		ArrayList<Long> list = new ArrayList<Long>();
		while(n > 0) {
			list.add((n % 10));
			n /= 10;
		}
		Collections.sort(list, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		return Long.parseLong(sb.toString());
	}
	public static long solution27My(long n) {			
		double x = Math.sqrt(n);
		long x1 = (long) x;
		if(x1 < x) {
			return -1; 
		} else {
			return (long) Math.pow(x1 + 1, 2);	
		}
	}
	
	public static int[] solution28My(int[] n) {
		if(n.length == 1) {
			int[] nAry = {-1};
			return nAry;
		}
		Integer[] IntAry = new Integer[n.length];
		for(int i = 0; i < n.length; i++) {
			IntAry[i] = n[i];
		}
		Arrays.sort(IntAry, Collections.reverseOrder());
		int[] nAry = new int[n.length - 1];
		for(int i = 0; i < n.length - 1; i++) {
			nAry[i] = IntAry[i];
		}
		return nAry;
	}
    public  String solution(int [] n, String hand) {
        StringBuilder bd = new StringBuilder();

        int leftLocation = 10;
        int rightLocation = 12;

        for(int number : n) {
            if(number ==1 || number == 4 || number == 7) {
                bd.append("L");
                leftLocation = number;
            }else if(number == 3 || number == 6 || number == 9) {
                bd.append("R");
                rightLocation = number;
            }else { // 2 5 8 0 
                int distanceL = getDist(leftLocation, number);
                int distanceR = getDist(rightLocation, number);

                if(distanceL > distanceR) {
                    bd.append("R");
                    rightLocation = number;
                }else if(distanceL < distanceR) {
                    bd.append("L");
                    leftLocation = number;
                }else {
                    if(hand.equals("right")) {
                        bd.append("R");
                        rightLocation = number;
                    }else {
                        bd.append("L");
                        leftLocation = number;
                    }
                }

            }
        }
        return bd.toString();
    }

    public static int getDist(int location, int number) {

        if(number == 0) {
            number = 11;
        }

        if(location == 0) {
            location = 11;
        }

        int locationX = (location-1) / 3;
        int locationY = (location-1) % 3;

        int numberX = (number-1) / 3;
        int numberY = (number-1) % 3;

        return Math.abs(locationX-numberX) + Math.abs(locationY - numberY);

    }
    public static int[] solution29My(int n, int m) {
    	
    	int gcd = gcd(n , m); // 최대공약수
    	int gcd1 = n * m / gcd; // 최소공배수
    	
    	int[] result = new int[2]; 
    	
    	result[0] = gcd;
    	result[1] = gcd1;
        return result;
    }
    public static int gcd(int n, int m) { // 유클리드 호제법 (최대공약수 구하기)
		if(m == 0) return n;
		return gcd(m, n%m);
	}
    
    public static int solution30My(int num) { //콜라츠 추측
    	// 입력된 수가 짝수면 2나눔
    	// 입력된 수가 홀수면 3곱하고 1을 더함
    	// 같은 작업 반복해서 1이될때 까지 반복.
    	int Cnt = 0;
    	long tempnum = num;
    	while(tempnum != 1) {
    		Cnt++;
    		if(Cnt == 501) {
    			Cnt = -1;
    			break;
    		}
    		if(tempnum % 2 == 0) {
    			tempnum /= 2;
        	} else {
        		tempnum *= 3;
        		++tempnum;
        	}	
    	}
        return Cnt;
    }
    
    public static double solution31My (int[] arr) {
    	
    	double AVG = avg(arr);
    	
    	return AVG;
    }
    
    public static double avg(int[] nAry) {
    	double temp = 0.0;
    	for(int i = 0; i < nAry.length; i++) {
    		temp += nAry[i];
    	}
    	temp /= nAry.length;
    	return temp;
	}
    public static boolean solution32My (int x) {
    	//하샤드 수
    	int tempX = x;
    	int hasadNum = 0;
    	while(x != 0) {
    		hasadNum += x % 10;
    		x /= 10;
    	}
    	if(tempX % hasadNum == 0) return true;
    	else return false;
    }
    public static String solution33My(String phone_number) {
    	StringBuilder result = new StringBuilder();
    	
    	for(int i = 0; i < phone_number.length() - 4; i++) {
    		result.append('*');
    	}
    	result.append(phone_number.substring(phone_number.length() - 3, phone_number.length() + 1));
    	return result.toString();
    }
    
    public static int[][] solution34My(int[][] arr1, int[][] arr2) {
		int[][] n2Ary = new int[arr1.length][arr1[0].length];
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[0].length; j++) {
				n2Ary[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return n2Ary;
	}
    public static long[] solution34My(int x, int n) {
		long[] nAry = new long[n];
		int temp = x;
		long x1 = 0;
		for(int i = 0; i < n; i++) {
			x1 += temp;
			nAry[i] = x1;
		}
		
    	return nAry;
	}
    public static void solution35My(int a, int b) {
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[][] c2Ary = new char[b][a];
		Arrays.fill(c2Ary[0], '*');
		StringBuilder sb = new StringBuilder();
		sb.append(c2Ary[0]);
		for(int i = 0; i < b; i++) {
    		try {
				bw.write(sb.toString());
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static int solution36My(int[] d, int budget) {
		int Cnt = 0;
		int plus = 0;
		Arrays.sort(d);
		for(int i = 0; i < d.length; i++) {
			plus += d[i];
			if(plus > budget)
				break;
			else {
				Cnt++;
			}
		}
		return Cnt;
	}
    
    public static String[] solution37My(int n, int[] arr1, int[] arr2) {
    	// 첫번째 지도에서 이진수 구하기.
    	int[] nAry = new int[n];
    	String[] strAry = new String[n];
    	StringBuilder temp = new StringBuilder();
    	for(int i = 0; i < arr1.length; i++) {
    		temp.setLength(0);
    		for(int j = 0; j < n - Integer.toBinaryString(arr1[i] | arr2[i]).length(); j++) {
    			temp.append(0);
    		}
    		temp.append(Integer.toBinaryString(arr1[i] | arr2[i]));
    		
    		strAry[i] = temp.toString();
    	}
    	String[] Result = new String[n];
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < strAry.length; i++) {
    		sb.setLength(0);
    		for(int j = 0; j < strAry[i].length(); j++) {
    			if(Character.getNumericValue(strAry[i].charAt(j)) == 0) {
    				sb.append(' ');
    			} else {
					sb.append('#');
				}
    		}
    		Result[i] = sb.toString();
    	}
    	return Result;
    }
    
    public static int[] solution38My(int N, int[] stages) {
    	// 실패율 계산          클리어 못한사람/ 클리어 한사람
    	Double[] DAry = new Double[N];
    	double fastNotClear = 0;
    	for(int i = 1; i < N + 1; i++) {
        	double NotClear = 0;
        	double Clear = 0;        	
    		for(int j = 0; j < stages.length; j++) {
    			if(stages[j] == 0)
    				continue;
    			if(i < stages[j]) {
    				Clear++;
    			}
    			else {
    				NotClear++;
    				stages[j] = 0;
    			}
    		}
    		
    		DAry[i - 1] = NotClear / (Clear + NotClear);
    	}
    	Double[] DAryCopy = Arrays.copyOf(DAry, DAry.length);
    	Arrays.sort(DAry, Collections.reverseOrder());
    	List<Integer> list = new ArrayList<Integer>();
    	
    	List<Integer> list1 = new ArrayList<Integer>();
    	for(int i = 0; i < DAry.length; i++) {
    		for(int j = 0; j < DAryCopy.length; j++) {
    			if(DAryCopy[j] == DAry[i]) {
    				if(Double.isNaN(DAryCopy[j])) {
    					list1.add(j + 1);
    					continue;
    				}
    				
    				list.add(j + 1);
    			}
    		}
    	}
    	
    	for(int i = 0; i < list1.size(); i++) {
    		list.add(list1.get(i));
    	}
    	
    	return list.stream().mapToInt(i -> (Integer)i).toArray();
    }
    
    public static int[] solution38(int N, int[] laststages) {
        int nPlayers = laststages.length;
        int[] nStagePlayers = new int[N + 2];
        for (int stage : laststages) {
            nStagePlayers[stage] += 1;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stages = new ArrayList<>();
        for (int id = 1 ; id <= N; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];

            Stage s = new Stage(id, failure);
            stages.add(s);
        }
        Collections.sort(stages, Collections.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stages.get(i).id;
        }
        return answer;
    }
    
    static class Stage implements Comparable<Stage> {
        public int id;
        public double failure;

        public Stage(int id_, double failure_) {
            id = id_;
            failure = failure_;
        }

        @Override
        public int compareTo(Stage o) {
            if (failure < o.failure ) {
                return -1;
            }
            if (failure > o.failure ) {
                return 1;
            }
            return 0;
        }
    }
    public static int solution39My(String dartResult) {
		
    	Map<Integer, Character> hashmap = new HashMap<Integer, Character>();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < dartResult.length() * 2; i += 2) {
    		if(dartResult.charAt(i) == '*') {
    			hashmap.put(i, '*');
    			i--;
    			continue;
    		}
    		if(dartResult.charAt(i) == '#') {
    			hashmap.put(i, '#');
    			i--;
    			continue;
    		}
    		sb.append(dartResult.charAt(i));
    	}
    	char[] cAry = sb.toString().toCharArray();
    	int result = 0;
    	for(int i = 0; i < cAry.length + 1; i++) {
    		if(cAry[i] >= 49 && cAry[i] <= 57) {
    			// 1이고 다음 글자에 0 있는지 없는지 검사
    			if(cAry[i] == 49) {
    				if(cAry[i + 1] == 48) {
    					// 있으면 10으로 간주
    					
    				}
    				else { // 문자면
    					
    				}
    			}
    			else {
    				
    			}
    		}
    		
    		if(i == cAry.length - 1)
    			break;
    	}
    	
    	
    	return 0;
	}
    public int solution39(String dartResult) {
        char[] darts = dartResult.toCharArray();
        int[] score = new int[3];
        int cnt = -1;
 
        for(int i = 0; i < darts.length; i++) {
            if(darts[i] >= '0' && darts[i] <= '9') {
                cnt++;
                if(darts[i] == '1' && darts[i+1] == '0') {
                    score[cnt] = 10;
                    i++;
                } else {
                    score[cnt] = darts[i] - '0';
                }
            } else if(darts[i] == 'D') {
                score[cnt] *= score[cnt];
            } else if(darts[i] == 'T') {
                score[cnt] *= score[cnt] * score[cnt];
            } else if(darts[i] == '*') {
                if(cnt > 0) {
                    score[cnt-1] *= 2;
                }
                score[cnt] *= 2;
            } else if(darts[i] == '#') {
                score[cnt] *= -1;
            }
        }
        return score[0] + score[1] + score[2];
    }
}


