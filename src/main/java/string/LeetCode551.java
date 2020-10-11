package string;

public class LeetCode551 {

    public static void main(String[] args) {
        System.out.println(checkRecord("ALLAPPL"));
    }

    public static boolean checkRecord(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == 'A' && ++ a > 1) {
                return false;
            }
            int l = 0;
            boolean flag = false;
            while (i < s.length() && s.charAt(i) == 'L') {
                if (++ l > 2) {
                    return false;
                }
                flag = true;
                i ++;
            }
            if (flag) {
                i --;
            }
        }
        return true;
    }

}
