package SWEA.거듭제곱1217;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			int N = sc.nextInt();
			int M =sc.nextInt();
			
			System.out.println("#" + t + " " + pow(N,M));
		}
	}
	
	public static int pow(int N, int M) {
		if(N == 1) return 1;
		if(M == 1) return N;
		
		return N * pow(N, M-1);
	}

}
