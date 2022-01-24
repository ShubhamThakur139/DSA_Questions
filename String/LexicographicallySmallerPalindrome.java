package String;

public class LexicographicallySmallerPalindrome {
    public static void main(String[] args) {
        String str = "adssaksda";

        String ans = smalLexPalin(str);
        System.out.println(ans);
    }

    static String smalLexPalin(String str) {
        int arr[] = new int[26];
        StringBuilder left = new StringBuilder();
        char mc = ' ';
        for (char ch : str.toCharArray()) {
            arr[ch - 'a']++;
        }
        boolean isFound = false;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0 && arr[i] % 2 == 0) {
                int val = arr[i] / 2;
                while (val-- != 0) {
                    left.append((char) (i + 'a'));
                }
            } else if (arr[i] > 0 && arr[i] % 2 != 0) {
                if (!isFound) {
                    mc = (char) (i + 'a');
                    isFound = true;
                }
                arr[i] = arr[i] - 1;
                int val = arr[i] / 2;
                while (val-- != 0) {
                    left.append((char) (i + 'a'));
                }
            }
        }
        StringBuilder right = new StringBuilder(left);
        // System.out.println(right.reverse());
        if (isFound) {
            left.append(mc);
        }
        left.append(right.reverse());
        return String.valueOf(left);
    }
}
