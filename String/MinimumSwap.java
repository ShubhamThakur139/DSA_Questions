package String;

// Pb St: Given two strings s1 and s2, the task is to find the minimum number of steps required to convert s1 into s2. The only operation allowed is to swap adjacent elements in the first string. Every swap is counted as a single step.
public class MinimumSwap {
    public static void main(String[] args) {
        // String s1 = "abcd";
        // String s2 = "cdab";
        String s1 = "abcfdegji";
        String s2 = "fjiacbdge";
        int minSwap = getMinSwap(s1, s2);

        System.out.println(minSwap);

    }

    private static int getMinSwap(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return -1;
        }
        if (!isAnagram(s1, s2, len1)) {
            return -1;
        } else {
            return minSwaps(s1.toCharArray(), s2.toCharArray(), len1);
        }
    }

    private static int minSwaps(char[] cs1, char[] cs2, int len1) {
        int i = 0, j = 0;
        int swaps = 0;
        while (i < len1) {
            j = i;
            while (cs1[i] != cs2[j]) {
                j++;
            }

            while (j > i) {
                char temp = cs2[j];
                cs2[j] = cs2[j - 1];
                cs2[j - 1] = temp;
                j--;
                swaps += 1;
            }

            i++;
        }
        return swaps;
    }

    private static boolean isAnagram(String s1, String s2, int len1) {
        int arr[] = new int[26];
        for (int i = 0; i < len1; i++) {
            int val = (int) (s1.charAt(i) - 'a');
            arr[val]++;
        }
        for (int i = 0; i < len1; i++) {
            int val = (int) (s2.charAt(i) - 'a');
            arr[val]--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

// Input ^
// string1 = "abcd";
// string2 = "cdab"
// ^
// output: 4