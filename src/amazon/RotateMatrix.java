package amazon;

/*
 * https://stackoverflow.com/questions/42519/how-do-you-rotate-a-two-dimensional-array
 * 
 * O(n^2) time and O(1) space algorithm
 * 
 * Rotate by +90:
 *     1. Transpose
 *     2. Reverse each row
 *   
 * Rotate by -90:
 *   Method 1 :
 *     1. Transpose
 *     2. Reverse each column
 *     
 *   Method 2 :
 *     1. Reverse each row
 *     2. Transpose
 *     
 * Rotate by +180:
 *   Method 1: Rotate by +90 twice
 *   Method 2: Reverse each row and then reverse each column (Transpose)
 *   
 * Rotate by -180:
 *   Method 1: Rotate by -90 twice
 *   Method 2: Reverse each column and then reverse each row
 *   Method 3: Rotate by +180 as they are same
 * 
 */

public class RotateMatrix {
	int[][] rotateArray(int[][] mat, int degree) {
		int deg = degree % 360;
		while (deg < 0) {
			deg += 360;
		}
		switch (deg) {
		case 0:
			return mat;
		case 90:
			return reverseRow(transpose(mat));
		case 180:
			return reverseCol(reverseRow(mat));
		case 270:
			return reverseCol(transpose(mat));
		default:
			System.out.println("To be continued...\n");
			return mat;
		}
	}
	
	int[][] transpose(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		int[][] ret = new int[col][row];
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				ret[i][j] = mat[j][i];
			}
		}
		return ret;
	}
	
	int[][] reverseRow(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		int[][] ret = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ret[i][j] = mat[i][j];
			}
		}
		
		for (int i = 0; i < row / 2; i++) {
			int[] tmp = ret[i];
			ret[i] = ret[row - 1 - i];
			ret[row - 1 - i] = tmp;
		}
		return ret;
	}
	
	int[][] reverseCol(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		int[][] ret = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ret[i][j] = mat[i][col - 1 - j];
			}
		}
		return ret;
	}
	
}
