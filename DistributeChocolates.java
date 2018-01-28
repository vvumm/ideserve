import java.util.Arrays;

public class DistributeChocolates {

	public static void main(String[] args) {
		int[] chocolatePackets = {12, 4, 7, 9, 2, 23, 25, 41 , 30, 40, 28, 42, 30, 44, 48, 43, 50};
		distributeChocolates(chocolatePackets, 7);
	}

	public static void distributeChocolates(int[] chocolatePackets, int n) {

		// If there are no chocolates or number of students is 0
		if(chocolatePackets == null || chocolatePackets.length == 0 || n == 0) {
			return;
		}

		// Sort the chocolatePackets
		Arrays.sort(chocolatePackets);
		System.out.println(Arrays.toString(chocolatePackets));

		int m = chocolatePackets.length;
		if(m < n) {
			System.out.println("Number of students is more than number of packets. Cannot distribute!");
			return;
		}
		int minDiff = chocolatePackets[m-1];    // Largest number of chocolates
		int first = 0;
		int last = 0;
		int diff = 0;
		for(int i = 0; i + n - 1 < m; i++) {
			diff = chocolatePackets[i+n-1] - chocolatePackets[i];
			if(diff < minDiff) {
				minDiff = diff;
				first = i;
				last = i+n-1;
			}
		}
		System.out.println(chocolatePackets[first] + " " + chocolatePackets[last]);
	}
}
