package amazon;

// Set Kth bit to 1
import java.util.ArrayList;
import java.util.List;

public class SetKthTo1 {
	int setKto1(int n, int k) {
		String s = Integer.toBinaryString(n);
		int length = s.length();
		if (s.charAt(length - k) == '1') {
			return n;
		}
		else {
			return n + (int)Math.pow(2, k-1);
		}
	}
	
	// Use loop to convert to binary string
	int findMax2(int number) {
		if (number < 2) {
			return 0;
		}
		int tmp = number;
		int digit = 0;
		while (tmp / 2 > 0) {
			tmp /= 2;
			digit++;
		}
		return digit;
	}
	
	int setKto1_loop(int n, int k) {
		List<Integer> digitList = new ArrayList<Integer>();
		int tmp = n;
		while (tmp != 0) {
			int res = findMax2(tmp);
			tmp = tmp - (int)Math.pow(2, res);
			digitList.add(res);
		}
		if (digitList.contains(k-1)) {
			return n;
		}
		else {
			return n + (int)Math.pow(2, k-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetKthTo1 setK = new SetKthTo1();
		int a = 30;
		int b = 1;
		System.out.println(Integer.toBinaryString(a));
		System.out.println("To binary String : " + setK.setKto1(a, b));
		System.out.println("Loop : " + setK.setKto1_loop(a, b));

	}

}
