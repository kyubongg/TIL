package SWEA.계산기1222;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int L = sc.nextInt();
			String str = sc.next();
			// 연산자 저장할 곳
			Stack<Character> stack = new Stack<>();
			// 후위식 저장할 곳
			StringBuilder postfix = new StringBuilder();
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(Character.isDigit(ch)) {
					postfix.append(ch);
				}else {
					if(stack.isEmpty()) {
						stack.push(ch);
					}else {
						postfix.append(stack.pop());
						stack.push(ch);
					}
				}
			}
			while(!stack.isEmpty()) postfix.append(stack.pop());
			
			Stack<Integer> intStack = new Stack<>();
			
			for(int i = 0; i < postfix.length(); i++) {
				char ch = postfix.charAt(i);
				// 숫자면 스택에 담는다.
				if(Character.isDigit(ch)) {
					intStack.push(ch - '0');
				}
				// 연산자면 숫자를 꺼내서 더한다.
				else {
					intStack.push((intStack.pop()) + (intStack.pop()));
				}
			}
			

			
			System.out.println("#" + t + " " + intStack.pop());
		}
	}

}
