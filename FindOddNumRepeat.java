public class FindOddNumRepeat {

	public static void printNumberOccuringOddNumberOfTimes(int[] input) {
		if(input == null || input.length == 0) {
			System.out.println("Empty input array." );
			return;
		}
		int result = input[0];
		for (int i = 1; i < input.length; i++) {
			result = result ^ input[i];
		}
		System.out.println("Number occurring odd number of times is "  + result);
	}

	public static void main(String[] args) {
		printNumberOccuringOddNumberOfTimes(new int[] {12, 13, 14, 13, 11, 14, 15, 11, 14, 12, 15});
	}
}
