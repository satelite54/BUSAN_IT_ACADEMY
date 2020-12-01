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
    // IntStream ������ ��ȯ�ϰ�(mapToint) + ���ٽ��� �̿��ϸ� ��Ʈ���� ��ȸ�� �� �ִ�.
    // ���ٽĿ��� �Է¸Ű������� i�� ���ϰ� stream(i)��°�� �հ踦 ���ϰ�, �ִ밪�� getAsInt() Int���� �ްڴ�.
    // �̷��Ե� Ǯ���� ����.
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
    // �����ϰ� �����ߴ�... �迭�� �ɰ��� ���ʴ�� �������� �� ���� �׷� �ʿ���µ�..
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
