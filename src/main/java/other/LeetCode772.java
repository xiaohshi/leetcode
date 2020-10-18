package other;

import java.util.Scanner;
import java.util.Stack;

//简单计算器，有括号，加减乘除
public class LeetCode772 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(calculate(s));
    }

    private static int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0, num = 0, i = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                int j = find(s.substring(i));
                num = calculate(s.substring(i + 1, i + j));
                i += j;
            }
            if (i == s.length() - 1 || !Character.isDigit(c)) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                }
                num = 0;
                op = c;
            }
            i ++;
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private static int find(String s) {
        int level = 0, i = 0;
        for (i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                level ++;
            } else if (c == ')') {
                level --;
                if (level == 0) {
                    break;
                }
            }
        }
        return i;
    }

}
