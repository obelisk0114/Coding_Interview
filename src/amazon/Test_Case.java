package amazon;

import java.util.Scanner;

public class Test_Case {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		RotateMatrix rotate = new RotateMatrix();
		
		// This part is for rotate matrix.
		System.out.println("Input the total amount of rows.");
		int row = keyboard.nextInt();
		System.out.println("Input the total amount of columns.");
		int col = keyboard.nextInt();
		System.out.println("Enter the rotation degree (clockwise).");
		int degree = keyboard.nextInt();
		System.out.println("Enter the elements: ");
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		matrix[i][j] = keyboard.nextInt();
        	}
        }
        
        int[][] ans1 = rotate.rotateArray(matrix, degree);
        for (int i = 0; i < ans1.length; i++) {
        	for (int j = 0; j < ans1[0].length; j++) {
        		System.out.print(ans1[i][j] + " ");
        	}
        	System.out.println();
        }
        
        
        keyboard.close();

	}

}
