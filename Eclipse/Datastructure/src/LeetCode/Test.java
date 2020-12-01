package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nAry = {{1,2,3},{3,2,1}};
		int n = maximumWealthMy(nAry);
		System.out.println(n);
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
}
