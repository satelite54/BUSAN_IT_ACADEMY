package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import Util.CLog;
import Util.CPrint;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		solution6My(array, commands);
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
}

