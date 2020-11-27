package LeetCode;

public class twoSumBruteForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SolutionMy {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = nums.length - 1; j >= 1; j--) {
                int tempSum = 0;
                tempSum = nums[i] + nums[j];
                if(tempSum == target) {
                    if(i == j)
                        continue;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}

class SolutionBruteForce{
	public int[] twoSum(int[] nums, int target) {
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++) {
	            if (nums[j] == target - nums[i]) {
	                return new int[] { i, j };
	            }
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
}
//The brute force approach is simple. 
//Loop through each element xx and find if there is another value that equals to target - x.
//흉포한 힘 접근은 간단하다. 각 원소 xx를 반복하여 목표값 x와 동일한 다른 값이 있는지 확인하십시오.

// 브루트 포스란?
// 완전 탐색 알고리즘으로 가능한 모든 경우의 수를 모두 탐색하고 조건에 맞는 결과만 가져옴
// 브루트 포스 알고리즘 설계 시 '해가 하나 이상 존재한다' 라는 가정을 세우고 모든 영역을 탐색
