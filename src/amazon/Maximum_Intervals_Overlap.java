package amazon;

import java.util.Arrays;

/*
 * Input: arrl[] = {1, 2, 9, 5, 5}
          exit[] = {4, 5, 12, 9, 12}
 *  First guest in array arrives at 1 and leaves at 4, 
 *  second guest arrives at 2 and leaves at 5, and so on.
 */

/*
 * https://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
 */

public class Maximum_Intervals_Overlap {
	/*
	 * The idea is to consider all events (all arrivals and exits) in sorted order. 
	 * Once we have all events in sorted order, we can trace the number of guests at 
	 * any time keeping track of guests that have arrived, but not exited.
	 */
	public void findMaxGuests_sort(int arrl[], int exit[], int n) {
		Arrays.sort(arrl);
		Arrays.sort(exit);

		// guests_in indicates number of guests at a time
		int guests_in = 1, max_guests = 1, time = arrl[0];
		int i = 1, j = 0;

		while (i < n && j < n) {
			// If next event in sorted order is arrival, increment count of guests
			if (arrl[i] <= exit[j]) {
				guests_in++;

				// Update max_guests if needed
				if (guests_in > max_guests) {
					max_guests = guests_in;
					time = arrl[i];
				}
				
				i++; // increment index of arrival array
			} 
			else { // If event is exit, decrement count of guests.
				guests_in--;
				j++;
			}
		}

		System.out.println("Maximum Number of Guests = " + max_guests + " at time " + time);
	}
	
	public void maxOverlap(int[] start, int[] end, int n) {
		// Finding maximum starting time
		int maxa = Arrays.stream(start).max().getAsInt();

		// Finding maximum ending time
		int maxb = Arrays.stream(end).max().getAsInt();

		int maxc = Math.max(maxa, maxb);

		int[] x = new int[maxc + 2];
		Arrays.fill(x, 0);

		int cur = 0, idx = 0;
		// CREATING AN AUXILIARY ARRAY
		for (int i = 0; i < n; i++) {// Lazy addition
			++x[start[i]];
			--x[end[i] + 1];
		}

		int maxy = Integer.MIN_VALUE;
		// Lazily Calculating value at index i
		for (int i = 0; i <= maxc; i++) {
			cur += x[i];
			if (maxy < cur) {
				maxy = cur;
				idx = i;
			}
		}
		System.out.println("Maximum value is: " + maxy + " at time: " + idx);
	}

	public static void main(String[] args) {
		Maximum_Intervals_Overlap mio = new Maximum_Intervals_Overlap();
		int arrl[] = {1, 2, 10, 5, 5};
        int exit[] = {4, 5, 12, 9, 12};
        int n = arrl.length;
        mio.findMaxGuests_sort(arrl, exit, n);
        mio.maxOverlap(arrl, arrl, n);
        
        int[] start = {13, 28, 29, 14, 40, 17, 3 };
        int[] end   = {107, 95, 111, 105, 70, 127, 74};
        mio.findMaxGuests_sort(start, end, n);
        mio.maxOverlap(start, end, n);
	}

}
