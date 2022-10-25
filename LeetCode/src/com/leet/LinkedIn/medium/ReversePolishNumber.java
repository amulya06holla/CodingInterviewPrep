package com.leet.LinkedIn.medium;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/solution/
// evaluation of postfix expression: eg: ""2","1","+","3","*""

// Also note: if it was a prefix expression, then solve by going from right to left of the array and do the same code.
//https://www.geeksforgeeks.org/evaluation-prefix-expressions/

public class ReversePolishNumber {

        public int evalRPN(String[] tokens) {
            Stack <Integer> stack = new Stack<>();
            for (String token : tokens) {
                if (!"+-*/".contains(token)) {
                    stack.push(Integer.valueOf(token));
                }else {
                    int number2=stack.pop();
                    int number1=stack.pop();
                    int result=0;
                    switch (token) {
                        case "+":
                            result=number1+number2;
                            break;
                        case "-":
                            result=number1-number2;
                            break;
                        case "*":
                            result=number1 * number2;
                            break;
                        case "/":
                            result=number1 / number2;
                            break;
                    }
                    stack.push(result);
                }
            }
            return stack.pop();
        }

}
