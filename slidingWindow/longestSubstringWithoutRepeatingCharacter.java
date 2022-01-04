package slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class longestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int length = lengthOfLongestSubstring(string);
        System.out.println(length);
        sc.close();
    }

    static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0, j = 0, result = 0;
        while (j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                int k = map.get(c);
                while (i <= k) {
                    map.remove(s.charAt(i));
                    i++;
                }
            }
            map.put(c, j);
            result = Math.max(result, j - i + 1);
            j++;

        }
        return result;
    }
}
