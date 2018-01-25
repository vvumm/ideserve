import java.util.Arrays;

public class PanCakeSorting {

	public static void pancakeSort(int[] array) {
		int n = array.length;
		for(int i = n-1; i > 0; i--) {
			int maxIdx = getMaxValueIndex(array, i);    // Find (n-i)th max element
			if(maxIdx != i) {
				if(maxIdx != 0) {
					flip(array, maxIdx);    // Flip array[0...maxIdx] to move ith max element to first position
				}
				flip(array, i);     // Flip array[0...i-1] to move ith max element to ith position
			}
		}
	}

	// Flip operation
	private static void flip(int[] array, int end) {
		int start = 0;
		while(start < end) {
			swap(array, start, end);
			start++;
			end--;
		}
	}

	private static void swap(int[] array, int start, int end) {
		int tmp = array[start];
		array[start] = array[end];
		array[end] = tmp;       
	}

	private static int getMaxValueIndex(int[] array, int end) {
		int max = 0;
		for(int i = 1; i <= end; i++) {
			if(array[max] < array[i]) {
				max = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = {4,1,2,5,3};
		pancakeSort(array);
		System.out.println(Arrays.toString(array));
	}
}
