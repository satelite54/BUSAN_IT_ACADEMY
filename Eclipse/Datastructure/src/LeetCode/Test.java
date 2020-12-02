package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.sun.jdi.CharType;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "codeleet";
		int[] nAry = {4, 5, 6, 7, 0, 2, 1, 3};
		System.out.println(restoreString(str, nAry));
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
}
