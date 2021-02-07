package Sort;

public class QuickSort {// 미리 정렬된 알고리즘인 경우 SelectionSort가 훨씬 빠름
	// 퀵 정렬은 분할 정복 알고리즘을 사용한다.

	// 퀵 정렬은 특정한 피벗(기준 값)을 이용해 왼쪽과 오른쪽을 나눈다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxValue = 5;
		int[] arr = new int[maxValue];
		IntArrayUtil.generateIntArrayRandom(arr, maxValue);
		int pibut = arr[0]; // 맨 앞에 피벗 값 설정
		// 왼쪽에서는 첫번쩨 피벗보다 큰 값을 찾고 오른쪽에서는 피벗보다 작은 값을 찾는다,
		// 찾으면 큰 값과 작은 값을 바꿔준다.
		// 왼쪽 인덱스와 오른쪽의 인덱스가 엇갈리면 작은 값의 인덱스와 피벗을 바꿔준다.
		// 바꾼 값을 기준으로 가장 왼쪽에 정렬 되지 않은 값과 오른쪽에서 가장 앞쪽 정렬되지 않은 값을 피벗으로 설정

		quickSort(arr, 0, maxValue - 1);
		IntArrayUtil.printIntArray(arr);
	}

	public static int partition(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2];

		while (left < right) {
			while ((arr[left] < pivot) && (left < right))
				left++;
			while ((arr[right] > pivot) && (left < right))
				right--;

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		return left;
	}
	public static void quickSort(int arr[], int left, int right) {
		if (left < right) {
			int pivotNewIndex = partition(arr, left, right);

			quickSort(arr, left, pivotNewIndex - 1);
			quickSort(arr, pivotNewIndex + 1, right);
		}

	}
}
