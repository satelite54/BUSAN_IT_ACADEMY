package Sort;

public class QuickSort {// �̸� ���ĵ� �˰����� ��� SelectionSort�� �ξ� ����
	// �� ������ ���� ���� �˰����� ����Ѵ�.

	// �� ������ Ư���� �ǹ�(���� ��)�� �̿��� ���ʰ� �������� ������.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxValue = 5;
		int[] arr = new int[maxValue];
		IntArrayUtil.generateIntArrayRandom(arr, maxValue);
		int pibut = arr[0]; // �� �տ� �ǹ� �� ����
		// ���ʿ����� ù���� �ǹ����� ū ���� ã�� �����ʿ����� �ǹ����� ���� ���� ã�´�,
		// ã���� ū ���� ���� ���� �ٲ��ش�.
		// ���� �ε����� �������� �ε����� �������� ���� ���� �ε����� �ǹ��� �ٲ��ش�.
		// �ٲ� ���� �������� ���� ���ʿ� ���� ���� ���� ���� �����ʿ��� ���� ���� ���ĵ��� ���� ���� �ǹ����� ����

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
