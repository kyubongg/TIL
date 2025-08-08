package SWEA.계산기1224;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> priority = new HashMap<>();
		
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('(', 0);
		
		
		
		for(int t = 1; t <= 10; t++) {
			// 문자열 길이
			int L = sc.nextInt();
			// 중위표현식 문자열
			String infix = sc.next();
			// 후위표현식 문자열
			StringBuilder postfix = new StringBuilder();
			// 연산자를 담을 스택
			Stack<Character> stack = new Stack<>();
			
			// 후위표현식으로 변환하는 반복문
			for(int i = 0; i < infix.length(); i++) {
				// infix의 한글자씩 가져옴
				char ch = infix.charAt(i);
				
				// ch가 숫자인지 아닌지 판단
				// ch가 숫자일 경우 postfix에 추가
				if(Character.isDigit(ch)) {
					postfix.append(ch);
				}
				// ch가 숫자가 아닌 경우 
				else {
					// ch가 여는 괄호일 때 -> stack에 추가
					if(ch == '(') {
						stack.push(ch);
					}
					// ch가 닫는 괄호일 때 -> '('가 나올때까지 스택을 pop
					else if(ch == ')') {
						while(stack.peek() != '(') {
							postfix.append(stack.pop());
						}
						// 여는 괄호 pop
						stack.pop();
					}
					// ch가 연산자일때
					else {
						if(stack.isEmpty()) stack.push(ch);
						else {
							// 연산자 우선순위를 고려해서 처리함.
							// 현재 연산자가 stack.peek()보다 우선순위가 낮으면 
							// 스택에 있는 연산자중 현재 연산자보다 우선순위가 큰 연산자를 다 꺼낸다.
							while(!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(ch)) {
								postfix.append(stack.pop());
							}
							stack.push(ch);
							
						}
					}
				}
			}
			
			// 더한 숫자를 저장할 스택
			Stack<Integer> intStack = new Stack<>();
			// 후위표현식을 계산하는 반복문
			for(int i = 0; i < postfix.length(); i++) {
				char ch = postfix.charAt(i);
				
				// ch가 숫자인지 아닌지 판단
				// 숫자라면 intStack에 넣는다.
				if(Character.isDigit(ch)) {
					intStack.push(ch - '0');
				}
				// 연산자라면 해당 연산자에 맞는 계산을 해줌
				else {
					int num1 = intStack.pop();
					int num2 = intStack.pop();
					
					switch(ch) {
						case '*':
							int mul = num1 * num2;
							intStack.push(mul);
							break;
						// 나누기는 나중에 들어간 숫자 / 먼저 들어간 숫자로 해야되기 때문에
						// num2가 num1 앞으로 온다.
						case '/':
							int div = num2 / num1;
							intStack.push(div);
							break;
						case '+':
							int plus = num1 + num2;
							intStack.push(plus);
							break;
						// 빼기도 나누기와 같은 이유로 num2가 num1 앞으로 온다.
						case '-':
							int minus = num2 - num1;
							intStack.push(minus);
							break;
					}
				}
			}
			
			System.out.println("#" + t + " " + intStack.pop());
			
			
		}
	}

}
