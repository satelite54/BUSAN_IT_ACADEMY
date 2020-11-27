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
//������ �� ������ �����ϴ�. �� ���� xx�� �ݺ��Ͽ� ��ǥ�� x�� ������ �ٸ� ���� �ִ��� Ȯ���Ͻʽÿ�.

// ���Ʈ ������?
// ���� Ž�� �˰������� ������ ��� ����� ���� ��� Ž���ϰ� ���ǿ� �´� ����� ������
// ���Ʈ ���� �˰��� ���� �� '�ذ� �ϳ� �̻� �����Ѵ�' ��� ������ ����� ��� ������ Ž��
