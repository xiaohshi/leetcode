package review.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FirstCode {

    public static void main(String[] args) {
        System.out.println(helper("cbacdcbc"));
    }

    private static String helper(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (visited[c - 'a']) {
                continue;
            }
            map.put(c, map.get(c) - 1);
            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

}
